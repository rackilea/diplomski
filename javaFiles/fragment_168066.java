@CallerSensitive
public ClassLoader getClassLoader() {
    ClassLoader cl = getClassLoader0();
    if (cl == null)
        return null;
    SecurityManager sm = System.getSecurityManager();
    if (sm != null) {
        ClassLoader.checkClassLoaderPermission(cl, Reflection.getCallerClass());
    }
    return cl;
}

// Package-private to allow ClassLoader access
ClassLoader getClassLoader0() { return classLoader; }

// Initialized in JVM not by private constructor
// This field is filtered from reflection access, i.e. getDeclaredField
// will throw NoSuchFieldException
private final ClassLoader classLoader;