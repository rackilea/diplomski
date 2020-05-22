class CancellableRunnable implements Runnable {

    private final AtomicBoolean shouldRun;
    private final Runnable delegate;

    public CancellableRunnable(AtomicBoolean shouldRun, Runnable delegate) {
        this.shouldRun = shouldRun;
        this.delegate = delegate;
    }

    @Override
    public void run() {
        if (shouldRun.get()) {
            delegate.run();
        }
    }
}