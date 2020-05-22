@SuppressWarnings("unchecked")
public void addURL(URL u) throws IOException {
    URLClassLoader sysLoader = (URLClassLoader) ThisClass.class.getClassLoader();
    URL urls[] = sysLoader.getURLs();
    for (int i = 0; i < urls.length; i++) {
        if (urls[i].toString().equalsIgnoreCase(u.toString())) {
            return;
        }
    }
    Class sysclass = URLClassLoader.class;
    try {
        Method method = sysclass.getDeclaredMethod("addURL", parameters);
        method.setAccessible(true);
        method.invoke(sysLoader, new Object[] { u });
    } catch (Throwable t) {
        throw new IOException("Error, could not add URL to system classloader");
    }
}