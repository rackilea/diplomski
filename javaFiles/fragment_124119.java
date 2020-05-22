private static URLClassLoader resourceLoader= null;

/**
 * Initialize class loader.
 */
static{
    ClassLoader currentThreadClassLoader
     = Thread.currentThread().getContextClassLoader();

    //assuming that current path is the project directory
    try {
        resourceLoader
         = new URLClassLoader(new URL[]{new File(".").toURI().toURL()},
                              currentThreadClassLoader);
    } catch (MalformedURLException e) {
        logger.error(e);
    }   
}

/**
 * Properties bundle name.
 */
private static final String BUNDLE_NAME = "resource.ExternalizedLogMessages"; //$NON-NLS-1$

/**
 * Resource bundle object.
 */
private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
        .getBundle(BUNDLE_NAME,Locale.US,resourceLoader);