public class WebappLoadListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {
    }

    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("\n\n\n ENDORSED DIR: " +System.getProperty("java.endorsed.dirs"));      
    }
}