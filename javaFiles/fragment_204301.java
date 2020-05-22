@Priority(1)
public class GuiceFeature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        ServiceLocator locator = ServiceLocatorProvider.getServiceLocator(context);
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(locator);
        Injector injector = Guice.createInjector(new TransportModule());
        GuiceIntoHK2Bridge guiceBridge = locator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(injector);
        return true;
    }
}