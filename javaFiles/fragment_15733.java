//Init executor
    int initialPoolSize = 5;
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(initialPoolSize);

    //[...] do something

    //Change max size
    int newPoolSize = 10;
    executor.setCorePoolSize(newPoolSize);