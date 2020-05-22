public OnDemandTask implements Runnable {
    private final BlockingQueue<?> signalQueue;

    public FeedbackTask(BlockingQueue<?> signalQueue) {
        this.signalQueue = signalQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // blocks until an object becomes available from the queue
                // may throw InterruptedException
                signalQueue.take();

                performTask();
            }
        } catch (InterruptedException ie) {
            // we've broken out of the loop; nothing further to do
        }
    }

    private performTask() {
        // ...
    }
}