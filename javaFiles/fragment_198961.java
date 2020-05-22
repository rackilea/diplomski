try {
    ClassLoader sysCl = ClassLoader.getSystemClassLoader();
    // not using single-arg Class.forName, since it would use the ClassLoader of this class,
    // which, in the worst-case scenario of being a non-delegating loader, could attempt to load AppClassLoader itself
    if (Class.forName("sun.misc.Launcher$AppClassLoader", false, sysCl).isAssignableFrom(sysCl.getClass())) {
        // default implementation, _most likely_ a URLClassLoader subclass
    }
    else {
        // System ClassLoader overridden, or not on OpenJDK
    }
}
catch (ReflectiveOperationException roe) {
    // most likely not on OpenJDK
}