private <T> T getService(Class<T> serviceName) {
        Bundle bundle = FrameworkUtil.getBundle(serviceName);
        if ( bundle == null ) {
            return null;
        }       
        BundleContext bundleContext = bundle.getBundleContext();
        ServiceReference serviceRef = bundleContext.getServiceReference(serviceName);  
        if (serviceRef == null)          
            return null;
        return (T) bundleContext.getService(serviceRef);
    }