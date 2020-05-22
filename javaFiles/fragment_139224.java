//quickfix
    //FrameworkUtil.getBundle(NodeManageDAO.class).getBundleContext()
    BundleContext bundleContext = FrameworkUtil.getBundle(PhotoNodeManagerDAO.class).getBundleContext();
    ServiceReference serviceReference = bundleContext.getServiceReference(SlingSettingsService.class.getName( ));
    SlingSettingsService slingSettingsService = (SlingSettingsService)bundleContext.getService(serviceReference);
    Set<String> runmode= slingSettingsService.getRunModes();

    //just in author mode
    if(runmode.contains("author")) {
        //attention replication from author is not working without nullable / delete the cq:distribute property
        node.setProperty("cq:distribute", (Value)null);
    }