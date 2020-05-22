package classes;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.joda.time.DateTime;

public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Project deployed: " + new DateTime());
        //or any other form of output
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Project undeployed: " + new DateTime());
        //or any other form of output
    }
}