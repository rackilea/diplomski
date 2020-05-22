package test;

import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class ConfigurationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        File configFile;

        try {
            configFile = new File(context.getResource("/WEB-INF/configuration.xml").getPath());
            Configuration config = new XMLConfiguration(configFile);
            context.setAttribute("configuration", config);
        } catch (ConfigurationException | MalformedURLException ex) {
            Logger.getLogger(ConfigurationListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}