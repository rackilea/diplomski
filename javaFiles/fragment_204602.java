@ApplicationPath("/")
public class MyApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public MyApplication () {
        // Register RequestContextFilter from Spring integration module. 
        register(RequestContextFilter.class);

        // Register JAX-RS root resource.
        register(JerseySpringResource.class);
    }
}