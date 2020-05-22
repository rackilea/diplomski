public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(new AppBinder());
    }
}