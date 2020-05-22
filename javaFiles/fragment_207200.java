private static final class SynchronizedRunnable implements Runnable {
    private final Object monitor;
    private final Runnable delegate;

    private SynchronizedRunnable(Object monitor, Runnable delegate) {
        this.monitor = monitor;
        this.delegate = delegate;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            delegate.run();
        }
    }
}