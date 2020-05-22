public class ContextAwareFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public String getConfigValue() {
        return (String)applicationContext.getBean("config-value");
    }
}