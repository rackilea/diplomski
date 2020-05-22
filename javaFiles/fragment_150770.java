public class YourBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RequestMappingHandlerMapping) {
              ((RequestMappingHandlerMapping) bean).setDefaultHandler(new UrlFilenameController());
        }
        return bean;
    }
}