public class SpringApplicationContext implements ApplicationContextAware {

private static ApplicationContext CONTEXT;

public void setApplicationContext(ApplicationContext context)
        throws BeansException {
    CONTEXT = context;
}
    public static Object getBean(String beanName) { ...}
    public static <T> T getBean(Class<T> arg0) {...}