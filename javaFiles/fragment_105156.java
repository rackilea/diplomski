public class ApplicationContextProvider implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static <T> T getEnvironmentProperty(String key, Class<T> targetClass, T defaultValue) {
        if (key == null || targetClass == null) {
            throw new NullPointerException();
        }

        T value = null;
        if (applicationContext != null) {
            System.out.println(applicationContext.getEnvironment().getProperty(key));
            value = applicationContext.getEnvironment().getProperty(key, targetClass, defaultValue);
        }
        return value;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}