public class DatabaseSingleton implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // initialize the database.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // close database
        System.out.println("close");
    }

}