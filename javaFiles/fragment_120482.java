public static void main(String[] args) throws InterruptedException {
    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    Runnable task = new Runnable() {
        @Override
        public void run() {
            System.out.println("Starting task");
            scheduler.schedule(stopTask(),500, TimeUnit.MILLISECONDS);
            try {
                System.out.println("Sleeping now");
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException ex) {
                System.out.println("I've been interrupted, bye bye");
            }
        }
    };

    scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS); //run task every second
    Thread.sleep(3000);
    scheduler.shutdownNow();
}

private static Runnable stopTask() {
    final Thread taskThread = Thread.currentThread();
    return new Runnable() {

        @Override
        public void run() {
            taskThread.interrupt();
        }
    };
}