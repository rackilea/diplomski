System.setSecurityManager(null);
    ClassLoader parentCL = AppBootstrap.class.getClassLoader();
    URL[] classpath = new URL[] {};
    if (parentCL instanceof URLClassLoader) {
        URLClassLoader ucl = (URLClassLoader) parentCL;
        classpath = ucl.getURLs();
    }
    final JwsUrlFixerClassLoader vlrCL = new JwsUrlFixerClassLoader(classpath, parentCL);
    Thread.currentThread().setContextClassLoader(vlrCL);
    try {
        SwingUtilities.invokeAndWait(new Runnable() {

            public void run() {
                Thread.currentThread().setContextClassLoader(vlrCL);
            }
        });
    } catch (Exception e) {
        LOG.error("main(): Failed to set context classloader !", e);
    }