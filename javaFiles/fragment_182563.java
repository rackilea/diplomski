public static void addResourceURLIntoClassPath(URL u) throws IOException {
    URLClassLoader urlLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
    Class<URLClassLoader> sysclass = URLClassLoader.class;
    try {
        Method method = sysclass.getDeclaredMethod("addURL", new Class[] { URL.class });
        method.setAccessible(true);
        method.invoke(urlLoader, new Object[] { u });
    } catch (Throwable t) {
        t.printStackTrace();
    } 
}