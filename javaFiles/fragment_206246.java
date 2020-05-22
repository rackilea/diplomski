package example;

import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.lang.reflect.Method;
import java.util.ConcurrentModificationException;

import sun.awt.EventQueueDelegate;

/**
 * Aims to organise filter chain of {@link EventQueueDelegate.Delegate}.
 * 
 * <pre>
 * private static final AwtResponsivenessMonitor instance = FilterEventQueueDelegate.chain(new AwtResponsivenessMonitor());
 * </pre>
 * 
 * @author Mykhaylo Adamovych
 */
public abstract class FilterEventQueueDelegate implements EventQueueDelegate.Delegate, AwtExceptionHandler {
    public static final class ExceptionHandler {
        private static AwtExceptionHandler currentExceptionHandler;

        public void handle(Throwable t) throws Throwable {
            currentExceptionHandler.handle(t);
        }
    }

    private static final class SimpleFilterEventQueueDelegate extends FilterEventQueueDelegate {
        private EventQueueDelegate.Delegate thirdPartyDelegate;
        private Object thirdPartyExceptionHandler;

        @Override
        public void afterDispatch(AWTEvent arg0, Object arg1) throws InterruptedException {
            if (thirdPartyDelegate != null)
                thirdPartyDelegate.afterDispatch(arg0, arg1);
        }

        @Override
        public Object beforeDispatch(AWTEvent arg0) throws InterruptedException {
            if (thirdPartyDelegate != null)
                return thirdPartyDelegate.beforeDispatch(arg0);
            return arg0;
        }

        @Override
        public AWTEvent getNextEvent(EventQueue arg0) throws InterruptedException {
            if (thirdPartyDelegate != null)
                return thirdPartyDelegate.getNextEvent(arg0);
            return arg0.getNextEvent();
        }

        @Override
        public void handle(Throwable t) throws Throwable {
            if (thirdPartyExceptionHandler != null)
                try {
                    Class<? extends Object> c = thirdPartyExceptionHandler.getClass();
                    Method m = c.getMethod("handle", new Class[] { Throwable.class });
                    m.invoke(thirdPartyExceptionHandler, new Object[] { t });
                } catch (Throwable x) {
                    thirdPartyExceptionHandler = null; /* Do not try this again */
                    throw t;
                }
            else
                throw t;
        }

        public void setEventQueueDelegate(EventQueueDelegate.Delegate delegate) {
            thirdPartyDelegate = delegate;
        }

        public void setExceptionHandler(Object exceptionHandler) {
            thirdPartyExceptionHandler = exceptionHandler;
        }
    }

    public static <T extends FilterEventQueueDelegate> T chain(T delegate) {
        synchronized (EventQueueDelegate.class) {
            EventQueueDelegate.Delegate currentDelegate = EventQueueDelegate.getDelegate();
            FilterEventQueueDelegate currentFilterDelegate = null;
            if (currentDelegate instanceof FilterEventQueueDelegate)
                currentFilterDelegate = (FilterEventQueueDelegate) currentDelegate;
            else {
                SimpleFilterEventQueueDelegate simpleFilterDelegate = new SimpleFilterEventQueueDelegate();
                if (currentDelegate != null)
                    simpleFilterDelegate.setEventQueueDelegate(currentDelegate);
                Object currentExceptionHandler = null;
                try {
                    currentExceptionHandler = Class.forName(System.getProperty("sun.awt.exception.handler")).newInstance();
                } catch (Exception e) {
                }
                if (currentExceptionHandler != null)
                    simpleFilterDelegate.setExceptionHandler(currentExceptionHandler);
                System.setProperty("sun.awt.exception.handler", ExceptionHandler.class.getName());
                currentFilterDelegate = simpleFilterDelegate;
            }
            delegate.setNext(currentFilterDelegate);
            EventQueueDelegate.setDelegate(delegate);
            if (EventQueueDelegate.getDelegate() != delegate)
                throw new ConcurrentModificationException();
            ExceptionHandler.currentExceptionHandler = delegate;
            return delegate;
        }
    }

    protected FilterEventQueueDelegate next;

    @Override
    public void afterDispatch(AWTEvent arg0, Object arg1) throws InterruptedException {
        next.afterDispatch(arg0, arg1);
    }

    @Override
    public Object beforeDispatch(AWTEvent arg0) throws InterruptedException {
        return next.beforeDispatch(arg0);
    }

    @Override
    public AWTEvent getNextEvent(EventQueue arg0) throws InterruptedException {
        return next.getNextEvent(arg0);
    }

    @Override
    public void handle(Throwable t) throws Throwable {
        next.handle(t);
    }

    private void setNext(FilterEventQueueDelegate eventQueueDelegate) {
        next = eventQueueDelegate;
    }
}