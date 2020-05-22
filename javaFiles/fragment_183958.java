static {
    ClassLoader cl = DefaultListableBeanFactory.class.getClassLoader();
    try {
        javaxInjectProviderClass = cl.loadClass("javax.inject.Provider"); //Line 103
    }
    catch (ClassNotFoundException ex) {
        // JSR-330 API not available - Provider interface simply not supported then.
    }
}