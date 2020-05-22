public class YourFeature implements Feature {
    @Override
    public void configure(FeatureContext context) {
        final ServiceLocator locator = ServiceLocatorProvider.getLocator(context);

        locator.inject(anyObject);

        context.register(new YourAbstractBinder());
    }
}

config.register(new YourFeature());