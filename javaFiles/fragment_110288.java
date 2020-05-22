public class MyApplicationContextInitializer implements
    ApplicationContextInitializer<GenericApplicationContext> {

public void initialize(GenericApplicationContext context) {
    context.getEnvironment().getSystemProperties().put(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "some_profile");
}