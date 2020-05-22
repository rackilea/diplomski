@WebListener
public class Config implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // Just write/call JDBC code here the usual way to create database/tables if not exists.
    }

    // ...
}