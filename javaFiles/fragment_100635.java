package dell.harmony.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * 
 * Utility Class to return the Spring ApplicationContext
 * 
 * 
 */
public class ApplicationContextProvider implements ApplicationContextAware {

    private static Logger logger = Logger.getLogger(ApplicationContextProvider.class);

    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        if (arg0 != null) {
            ctx=arg0;
        }
    }

    public synchronized static ApplicationContext getApplicationContext(){
        if (ctx==null) {
            logger.info("Getting the context again as it is null");
            ctx = new ClassPathXmlApplicationContext("SpringModule.xml");
        }
        return ctx;
    }

}