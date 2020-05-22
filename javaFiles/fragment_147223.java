private static ClassLoader contextClassLoader;

static {
contextClassLoader =
    (ClassLoader)java.security.AccessController.doPrivileged
            (new java.security.PrivilegedAction() {
            public Object run() {
                return Thread.currentThread().getContextClassLoader();
            }
    });
};