import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.AbstractFactoryBean;

public class ExternalBeanReferneceFactoryBean extends AbstractFactoryBean implements BeanNameAware {

    private static Map<String, Object> instances = new HashMap<String, Object>();
    private String beanName;

    /**
     * @param instance the instance to set
     */
    public static void setInstance(String beanName, Object instance) {
        instances.put(beanName, instance);
    }

    @Override
    protected Object createInstance() 
        throws Exception {
        return instances.get(beanName);
    }

    @Override
    public Class<?> getObjectType() {
        return instances.get(beanName).getClass();
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

}