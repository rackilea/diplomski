public class MyDaemonServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        Thread th = new Thread() {
            public void run() {
                // implement daemon logic here.
            }
        };
        th.setDaemon(true);
        th.start();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // you could notify your thread you're shutting down if 
        // you need it to clean up after itself
    }
}