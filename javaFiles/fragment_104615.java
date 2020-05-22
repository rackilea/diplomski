public static Long getTime(Class<?> cl) {
    try {
        String rn = cl.getName().replace('.', '/') + ".class";
        JarURLConnection j = (JarURLConnection) cl.getClassLoader().getResource(rn).openConnection();
        return j.getJarFile().getEntry("META-INF/MANIFEST.MF").getTime();
    } catch (Exception e) {
        return null;
    }
}