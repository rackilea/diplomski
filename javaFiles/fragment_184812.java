public static void main(String[] args) {
    ScheduledExecutorService task = Executors.newScheduledThreadPool(10);
    AtomicInteger counter = new AtomicInteger(0);
    ThreadLocal<Integer> id = ThreadLocal.withInitial(counter::incrementAndGet);
    int i = 0;
    while (i < 10) {
        // sleep 5 seconds
        sleep(5);
        task.scheduleAtFixedRate(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(String.format("[%s] counter = %d" , threadName, id.get()));
        }, 0, 2, TimeUnit.SECONDS);

        ++i;
    }
}

private static void sleep(int sleepTime) {
    try {
        TimeUnit.SECONDS.sleep(sleepTime);
    } catch (InterruptedException ie) {

    }
}