import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenToMeFirst implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // Run me First while deploying!!!

    }

}