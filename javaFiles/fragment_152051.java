import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringApplicationContextContainer implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Autowired
    public SpringApplicationContextContainer(ApplicationContext applicationContext) {
        SpringApplicationContextContainer.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationContextContainer.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return SpringApplicationContextContainer.applicationContext;
    }
}