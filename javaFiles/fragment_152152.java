public class EnvironmentApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private final JndiLocatorDelegate jndi = JndiLocatorDelegate.createDefaultResourceRefLocator();

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        String profile = jndi.lookup("bla/environment", String.class); 
        applicationContext.getEnvironment().addActiveProfile(profile);
    }
}