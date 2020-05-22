Runnable task  = () -> doSomething();
ScheduledExecutorService executor = 
Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
// Schedule a task that will be executed in 120 sec
executor.schedule(task, 120, TimeUnit.SECONDS);

// Schedule a task that will be first run in 120 sec and each 120sec
// If an exception occurs then it's task executions are canceled.
executor.scheduleAtFixedRate(task, 120, 120, TimeUnit.SECONDS);

// Schedule a task that will be first run in 120 sec and each 120sec after 
the last 
execution
// If an exception occurs then it's task executions are canceled.
executor.scheduleWithFixedDelay(task, 120, 120, TimeUnit.SECONDS);