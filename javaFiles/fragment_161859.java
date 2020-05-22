public static JarFile getJarFile(Class<?> cl) {
    URL classUrl = cl.getResource(cl.getSimpleName() + ".class");
    if (classUrl != null) {
        try {
            URLConnection conn = classUrl.openConnection();
            if (conn instanceof JarURLConnection) {
                JarURLConnection connection = (JarURLConnection) conn;
                return connection.getJarFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    return null;
}

public static SVNVersion fromResources(Class<?> cl) {
    JarFile jarFile = getJarFile(cl);
    ZipEntry entry = jarFile.getEntry("svnversion.properties");
    Properties props = new Properties();
    try {
        props.load(jarFile.getInputStream(entry));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    if (props.containsKey("svnversion")) {
        String svnv = props.getProperty("svnversion");
        return fromString(svnv);
    } else {
        return null;
    }
}