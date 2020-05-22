public class ProfileContextInitializer implements
        ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        PropertySource<Map<String, Object>> source = null;
        try {
            source = new ResourcePropertySource("spring.properties");
            String profile = (String) source.getProperty("active.profile");
            System.out.println(profile);
            ConfigurableEnvironment env = applicationContext.getEnvironment();
            env.setActiveProfiles(profile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}