private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

public static void main(String[] args) {
    // Some service code here
    generateForAnHour();
}

public static void generateForAnHour() {
    // Some code that does work
    final Runnable runner = () -> System.out.println("Running...");

    final ScheduledFuture<?> generatorHandle = scheduler.scheduleAtFixedRate(runner, 0, 1, TimeUnit.SECONDS);
    // Code that interrupts the worker after a specified time
    scheduler.schedule(scheduler::shutdown, 5, TimeUnit.SECONDS);
}