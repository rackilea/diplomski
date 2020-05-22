public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        getClass().getClassLoader().setDefaultAssertionStatus(true);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }
}