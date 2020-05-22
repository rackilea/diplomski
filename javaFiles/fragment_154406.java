private volatile ScheduledExecutorService executor;

public void contextInitialized(ServletContextEvent sce)
{
    executor = Executors.newScheduledThreadPool(2);
    executor.scheduleAtFixedRate(myRunnable, 0, 3, TimeUnit.MINUTES);
}

public void contextDestroyed(ServletContextEvent sce)
{
    final ScheduledExecutorService executor = this.executor;

    if (executor != null)
    {
        executor.shutdown();
        this.executor = null;
    }
}