@ApplicationPath("/")
public class MyRESTAPIApp extends ResourceConfig{
    public MyRESTAPIApp () {
        packages("com.mypackage.resource", "com.mypackage.providers");
        register(org.glassfish.jersey.filter.LoggingFilter.class);
        property("jersey.config.beanValidation.enableOutputValidationErrorEntity.server", "true");
    }
}