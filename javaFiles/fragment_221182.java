public class ServiceLocator implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * @return Returns the applicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(Class<T> requiredType) throws BeansException {
        return getApplicationContext().getBean(requiredType);
    }

    /**
     * @param applicationContext The applicationContext to set.
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        ServiceLocator.applicationContext = applicationContext;
    }

}