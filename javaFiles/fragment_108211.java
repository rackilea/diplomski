public static void main(String[] args) {
    // using a low limit so it doesn't take too long for the queue to fill
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    Runnable producer = () -> {
        if (!queue.offer(randomString())) {
            System.out.println("queue was full!");
        }
    };
    Runnable consumer = () -> {
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
    // produce faster than consume so the queue becomes full eventually
    executor.scheduleAtFixedRate(producer, 0, 100, TimeUnit.MILLISECONDS);
    executor.scheduleAtFixedRate(consumer, 0, 200, TimeUnit.MILLISECONDS);
}