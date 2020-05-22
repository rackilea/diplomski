// Create a shared executor with a single thread
private final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

// Instead of creating a Timer, schedule the task
executor.schedule(() -> {
    // Do what you need here
}, 1, TimeUnit.SECONDS);

// Don't forget to terminate the scheduler when you don't need it anymore
scheduler.terminate();