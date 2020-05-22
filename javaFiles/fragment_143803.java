class Producer implements Runnable {
    private final BlockingQueue<Double> queue;

    public Producer(BlockingQueue<Double> q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                Double result = calculateResult();
                // This call will make the result available to the consumer:
                queue.put(result);
            }
        } catch (InterruptedException ex) {
            // Handle thread interruption here
        }
    }
}