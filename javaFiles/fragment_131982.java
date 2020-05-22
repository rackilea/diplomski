class MultiplyThread implements Runnable {

    private boolean active = true;
    private Integer result = 1;
    private final Queue<Integer> queue;

    public MultiplyThread(ConcurrentLinkedQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while (isActive()) {
            Integer number = queue.poll();
            if (number != null) {
                result *= number;
                System.out.println("MultiplyThread current result is " + result);
            }
        }
    }

    public synchronized void stop() {
        active = false;
    }

    public synchronized boolean isActive() {
        return active;
    }
}