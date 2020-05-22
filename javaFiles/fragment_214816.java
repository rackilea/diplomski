@ApplicationPath("/")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        // Resources.
        packages(MyResource.class.getPackage().getName());

        register(LoggingFilter.class);    
    }
}