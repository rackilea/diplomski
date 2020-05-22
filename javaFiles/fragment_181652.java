@Provider
public final class StartupListener implements Feature {

    private final ServiceLocator serviceLocator;

    @Inject
    public StartupListener(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public boolean configure(FeatureContext context) {
        ServiceLocatorUtilities.bind(serviceLocator, new AbstractBinder() {
            @Override
            protected void configure() {
                bind(new StringHolder("injected string")).to(StringHolder.class);
            }
        });
        return true;
    }
}