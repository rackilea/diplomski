public void init() {
    executor = new ScheduledThreadPoolExecutor(corePoolSize);
    executor.scheduleWithFixedDelay(new WorkerThread(), 10, 5, TimeUnit.SECONDS);
}

public void end() {
    executor.shutdown();
}