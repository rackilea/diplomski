import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.launch.Framework;

public class ShutdownHookActivator implements BundleActivator {

    @Override
    public void start(final BundleContext context) {
        Thread hook = new Thread() {
            @Override
            public void run() {
                System.out.println("Shutdown hook invoked, stopping OSGi Framework.");
                try {
                    Framework systemBundle = context.getBundle(0).adapt(Framework.class);
                    systemBundle.stop();
                    System.out.println("Waiting up to 2s for OSGi shutdown to complete...");
                    systemBundle.waitForStop(2000);
                } catch (Exception e) {
                    System.err.println("Failed to cleanly shutdown OSGi Framework: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        };
        System.out.println("Installing shutdown hook.");
        Runtime.getRuntime().addShutdownHook(hook);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }

}