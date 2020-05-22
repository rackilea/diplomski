public class AppConfig extends ResourceConfig {
    public AppConfig() {
        register(new AbstractBinder() {
            @Override
            public void configure() {
                bind(new SseBroadcaster()).to(SseBroadcaster.class);
            }
        });
    }
}