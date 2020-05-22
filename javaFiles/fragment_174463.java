public static void addToClassPath(String jarFile) throws IOException 
{
    URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
    Class loaderClass = URLClassLoader.class;

    try {
        Method method = loaderClass.getDeclaredMethod("addURL", new Class[]{URL.class});
        method.setAccessible(true);
        method.invoke(classLoader, new Object[]{ new File(jarFile).toURL() });
    } catch (Throwable t) {
        t.printStackTrace();
        throw new IOException( t );
    }
}