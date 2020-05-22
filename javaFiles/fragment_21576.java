public class BackgroundServletContextListener implements ServletContextListener {
    private ScheduledExecutorService executor;
    private BackgroundService service;

    public void contextInitialized(ServletContextEvent sce) {
        service = new BackgroundService();

        // setup single thread to run background service every 5 minutes
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(service, 0, 5, TimeUnit.MINUTES);

        // make the background service available to the servlet context
        sce.getServletContext().setAttribute("service", service);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        executor.shutdown();
    }
}

public class BackgroundService implements Runnable {
    public void run() {
        // do your background processing here
    }
}