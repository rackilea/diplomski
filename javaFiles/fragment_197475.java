import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



/**
 * Class to listen for application startup and shutdown
 * 
 * @author HBR
 * 
 */
public class ApplicationListener implements ServletContextListener {
    private static Logger logger = Logger.getLogger(ApplicationListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("class : context destroyed");

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        ///// HERE You launch your class
        logger.info("myapp : context Initialized");
    }



}