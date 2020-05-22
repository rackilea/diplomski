public static boolean verifyJavaVersion() throws UserException {
    String javaVersion = ...
    int installedJavaVersion = extractJavaVersion(javaVersion);
    int installedJavaReleaseVersion = extractJavaReleaseVersion(javaVersion);
    checkVersion(installedJavaVersion, REQUIRED_JAVA_VERSION, installedJavaReleaseVersion, MINIMUM_JAVA_RELEASE_VERSION);
}