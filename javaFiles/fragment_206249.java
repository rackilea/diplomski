package example;

import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import sun.awt.EventQueueDelegate;

public class Example {
    public static class ThirdPartyEventQueueDelegate implements EventQueueDelegate.Delegate {
        public static final void registerEventQueueDelegate() {
            EventQueueDelegate.setDelegate(new ThirdPartyEventQueueDelegate());
        }

        @Override
        public void afterDispatch(AWTEvent arg0, Object arg1) throws InterruptedException {
            System.out.println("Third party even queue delegate was not broken.");
        }

        @Override
        public Object beforeDispatch(AWTEvent arg0) throws InterruptedException {
            return arg0;
        }

        @Override
        public AWTEvent getNextEvent(EventQueue arg0) throws InterruptedException {
            return arg0.getNextEvent();
        }
    }

    public static class ThirdPartyExceptionHandler {
        public static void registerExceptionHandler() {
            System.setProperty("sun.awt.exception.handler", ThirdPartyExceptionHandler.class.getName());
        }

        public void handle(Throwable t) {
            System.out.println("Third party Exception handler was not broken.");
        }
    }

    private static boolean wasIdle = false;
    private static boolean isFistTime = true;

    public static synchronized void log(String msg) {
        System.out.println(new SimpleDateFormat("mm:ss.SSS").format(new Date()) + "\t" + msg);
    }

    public static void main(String[] args) {
        // let suppose there are some related stuff already
        ThirdPartyExceptionHandler.registerExceptionHandler();
        ThirdPartyEventQueueDelegate.registerEventQueueDelegate();
        // initialise singletons, build filter chain
        AwtIdleTracker.getInstance();
        AwtResponsivenessMonitor.setResponsivenessTimeout(TimeUnit.SECONDS.toMillis(2));
        testWaitForIdle();
        // testSomeGui();
    }

    public static void testSomeGui() {
        // some test with visible GUI
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        while (true) {
            boolean isIdle = AwtIdleTracker.getInstance().isIdle();
            if (isFistTime || wasIdle != isIdle) {
                isFistTime = false;
                wasIdle = isIdle;
                String msg = isIdle
                        ? "idle"
                        : "busy";
                log("system becomes " + msg);
            }
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(1));
        }
    }

    public static void testWaitForIdle() {
        // some long operation
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log("task started");
                // throw new RuntimeException();
                LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));
                log("task finished");
            }
        });
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100));
        log("started waiting for idle");
        AwtIdleTracker.getInstance().waitForIdle();
        log("stopped waiting for idle");
    }
}