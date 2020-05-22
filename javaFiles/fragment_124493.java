private static final boolean standardReflectionAvailable =
        (JdkVersion.getMajorJavaVersion() >= JdkVersion.JAVA_18);


public DefaultParameterNameDiscoverer() {
    if (standardReflectionAvailable) {
        addDiscoverer(new StandardReflectionParameterNameDiscoverer());
    }
    addDiscoverer(new LocalVariableTableParameterNameDiscoverer());
}