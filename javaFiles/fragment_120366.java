public class HostApplication {
    private BundleContext bundleContext;

    public HostApplication(String profileName) {
        BundleContext bc = null;
        Properties frameworkProperties = readCustomProfile(profileName);

        frameworkProperties.put("osgi.clean", "true");
        frameworkProperties.put("osgi.console", "true");

        Map<String, String> frameworkPropertiesMap = new HashMap<String, String>();
        for (Object o : frameworkProperties.keySet()) {
            frameworkPropertiesMap.put((String) o,
                    (String) frameworkProperties.getProperty((String) o));
        }

        EclipseStarter.setInitialProperties(frameworkPropertiesMap);
        bc = EclipseStarter.startup(new String[] { "-console", "-dev", "bin" },    null);
    }

   public boolean containsIegm(String stage, byte[] msg) {

        try {
            ServiceReference serviceReference = bundleContext.getServiceReference(ParserTest.class.getName());
            return ((ParserImplService) bundleContext.getService(serviceReference)).containsIegm(msg);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public void installBundlesFromDir() {

        File dir = new File("bundles");
        int i = 0;
        for (File f : dir.listFiles()) {
            try {
                Bundle b = bundleContext.installBundle("file:"+ f.getAbsolutePath());
                b.start();
            } catch (BundleException e) {
                System.err.println("could not load bundle "    + f.getAbsolutePath());
            }
        }

    }
}