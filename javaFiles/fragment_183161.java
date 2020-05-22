@WebListener
public class Config implements ServletContextListener {

    @Override 
    public void contextInitialized(ServletContextEvent event) {
        // Do stuff during webapp's startup.
    }

    @Override 
    public void contextDestroyed(ServletContextEvent event) {
        // Do stuff during webapp's shutdown.
    }

}