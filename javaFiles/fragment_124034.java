import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ContextLoader;

public final class EmbeddedJettySpringContextLoaderListener extends ContextLoader implements ApplicationContextAware, ServletContextListener
{
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * Returns the parent application context as set by the
     * {@link ApplicationContextAware} interface.
     * 
     * @return The initial ApplicationContext that loads the Jetty server.
     */
    @Override
    protected ApplicationContext loadParentContext(ServletContext servletContext) {
        return this.applicationContext;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        super.initWebApplicationContext(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //not needed
    }
}