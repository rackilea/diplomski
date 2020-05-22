package example;

import java.awt.AWTEvent;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

import javax.swing.SwingUtilities;

import sun.awt.SunToolkit;

/**
 * Tracks {@code EventDispatchThread} idleness.
 * <p>
 * Singleton is initialised on first access.
 * 
 * @author Mykhaylo Adamovych
 */
public class AwtIdleTracker extends FilterEventQueueDelegate {
    public static final long DEFAULT_IDLE_TIME_TO_TRACK_MS = 1000;
    private static final long IDLE_TIME_WATCHDOG_MS = 10;
    private static final AwtIdleTracker instance = FilterEventQueueDelegate.chain(new AwtIdleTracker());

    public static AwtIdleTracker getInstance() {
        return instance;
    }

    private volatile boolean inProgress;
    private final AtomicLong lastDispatchTime = new AtomicLong(0);

    @Override
    public void afterDispatch(AWTEvent arg0, Object arg1) throws InterruptedException {
        lastDispatchTime.set(System.currentTimeMillis());
        inProgress = false;
        super.afterDispatch(arg0, arg1);
    }

    @Override
    public Object beforeDispatch(AWTEvent arg0) throws InterruptedException {
        inProgress = true;
        return super.beforeDispatch(arg0);
    }

    @Override
    public void handle(Throwable t) throws Throwable {
        lastDispatchTime.set(System.currentTimeMillis());
        inProgress = false;
        super.handle(t);
    }

    public boolean isIdle() {
        return this.isIdle(DEFAULT_IDLE_TIME_TO_TRACK_MS);
    }

    public boolean isIdle(long idleTimeToTrackMs) {
        return !inProgress && SunToolkit.isPostEventQueueEmpty() && System.currentTimeMillis() > lastDispatchTime.get() + idleTimeToTrackMs;
    }

    public void waitForIdle() {
        waitForIdle(DEFAULT_IDLE_TIME_TO_TRACK_MS);
    }

    public void waitForIdle(long idleTimeToTrackMs) {
        waitForIdle(idleTimeToTrackMs, TimeUnit.DAYS.toMillis(365));
    }

    public void waitForIdle(long idleTimeToTrackMs, long timeoutMs) {
        if (SwingUtilities.isEventDispatchThread())
            throw new IllegalAccessError();
        long staleThreshold = System.currentTimeMillis() + timeoutMs;
        while (!isIdle(idleTimeToTrackMs)) {
            if (System.currentTimeMillis() > staleThreshold)
                throw new RuntimeException("GUI still is not idle.");
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(IDLE_TIME_WATCHDOG_MS));
        }
    }
}