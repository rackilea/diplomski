package example;

import java.awt.AWTEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Monitors {@code EventDispatchThread} responsiveness.
 * <p>
 * Singleton is initialised on first access.
 * 
 * @author Mykhaylo Adamovych
 */
public class AwtResponsivenessMonitor extends FilterEventQueueDelegate {
    private static final class DeamonThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread result = new Thread(r);
            result.setName(AwtResponsivenessMonitor.class.getSimpleName());
            result.setDaemon(true);
            return result;
        }
    }

    private static final class NotResponsive extends RuntimeException {
        private static final long serialVersionUID = -1445765918431458354L;
    }

    public static final long DEFAULT_RESPONSIVENESS_TIMEOUT_S = 2;
    public static final long RESPONSIVENESS_WATCHDOG_MS = 50;
    private static final AwtResponsivenessMonitor instance = FilterEventQueueDelegate.chain(new AwtResponsivenessMonitor());

    public static AwtResponsivenessMonitor getInstance() {
        return instance;
    }

    public static long getResponsivenessTimeout() {
        return instance.responsivenessTimeoutMs.get();
    }

    public static void setResponsivenessTimeout(long timeoutMs) {
        instance.responsivenessTimeoutMs.set(timeoutMs);
    }

    private final AtomicLong responsivenessTimeoutMs = new AtomicLong(TimeUnit.SECONDS.toMillis(DEFAULT_RESPONSIVENESS_TIMEOUT_S));
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new DeamonThreadFactory());
    private long eventDispatchStartTime;
    private Thread currentWorkingThread;

    public AwtResponsivenessMonitor() {
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                checkResponsiveness();
            }
        }, RESPONSIVENESS_WATCHDOG_MS, RESPONSIVENESS_WATCHDOG_MS, TimeUnit.MILLISECONDS);
    }

    @Override
    public synchronized void afterDispatch(AWTEvent arg0, Object arg1) throws InterruptedException {
        eventDispatchStartTime = 0;
        super.afterDispatch(arg0, arg1);
    }

    @Override
    public synchronized Object beforeDispatch(AWTEvent arg0) throws InterruptedException {
        eventDispatchStartTime = System.currentTimeMillis();
        currentWorkingThread = Thread.currentThread();
        return super.beforeDispatch(arg0);
    }

    private synchronized void checkResponsiveness() {
        if (eventDispatchStartTime != 0 && currentWorkingThread != null && System.currentTimeMillis() > eventDispatchStartTime + responsivenessTimeoutMs.get()) {
            Exception e = new NotResponsive();
            e.setStackTrace(currentWorkingThread.getStackTrace());
            e.printStackTrace();
            currentWorkingThread = null;
        }
    }

    @Override
    public synchronized void handle(Throwable t) throws Throwable {
        eventDispatchStartTime = 0;
        super.handle(t);
    }
}