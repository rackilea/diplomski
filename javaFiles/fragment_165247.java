/**
 * Application config
 */
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        register(SomeResources.class, SomeProviders.class);

        // Register different Binders
        addBinders(new MyBinder());
    }
}