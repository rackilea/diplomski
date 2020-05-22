public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        bundleContext.registerService(CommandProvider.class.getName(),
                new Calculator(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }
}