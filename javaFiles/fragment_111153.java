import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class QuartzInitiator implements ServletContextListener {

     public void contextInitialized(ServletContextEvent servletContextEvent) {
            WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext())
           .getAutowireCapableBeanFactory().autowireBean(this);
          //your logic
     }
}