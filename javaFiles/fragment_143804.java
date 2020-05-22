class Consumer implements Runnable {
    private final BlockingQueue<Double> queue;

    public Consumer(BlockingQueue<Double> q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                // This call Will wait until the next result is available:
                Double result = queue.take();
                // Process the result...
            }
        } catch (InterruptedException ex) {
            // Handle thread interruption here
        }
    }
}