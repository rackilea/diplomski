public static int getMajorVersion() {
    try {
        // use Java 9+ version API via reflection, so it can be compiled for older versions
        Method runtime_version = Runtime.class.getMethod("version");
        Object version = runtime_version.invoke(null);
        Method version_major = runtime_version.getReturnType().getMethod("major");
        return (int) version_major.invoke(version);
    // do not catch `ReflectiveOperationException` because it does not exist in Java <7
    } catch (Exception ex) {
        // before Java 9 system property 'java.specification.version'
        // is of the form '1.major', so return the int after '1.'
        String versionString = System.getProperty("java.specification.version");
        return Integer.parseInt(versionString.substring(2));
    }
}