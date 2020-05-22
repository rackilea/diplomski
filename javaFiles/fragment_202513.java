package test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // startup code here
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // shutdown code here
    }

}