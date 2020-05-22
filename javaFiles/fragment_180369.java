public class HibernateContextListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent sce) {
        HibernatePersistenceProviderResolver.register();    
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // nothing to do here
    }
}