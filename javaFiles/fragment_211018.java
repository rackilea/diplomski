public class Config implements ServletContextListener {

    private YourApp yourApp;

    public void contextInitialized(ServletContextEvent event) {
        yourApp = new YourApp();
        yourApp.start();
    }

    public void contextDestroyed(ServletContextEvent event) {
        yourApp.shutdown();
    }

}