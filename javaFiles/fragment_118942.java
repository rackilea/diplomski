public static void addUrl(URL u) {
    URLClassLoader sysloader = (URLClassLoader) ClassLoader
            .getSystemClassLoader();
    Class<URLClassLoader> sysclass = URLClassLoader.class;

    try {
        Method method = sysclass.getDeclaredMethod("addURL", parameters);
        method.setAccessible(true);
        method.invoke(sysloader, new Object[] { u });
    } catch (Throwable t) {
        t.printStackTrace();
        try {
            throw new IOException(
                    "Error, could not add URL to system classloader");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}