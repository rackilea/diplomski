private void addFile(File f) throws IOException // URL to your plugin jar file
{
    addURL(f.toURI().toURL());
}

private void addURL(URL u) throws IOException
{
    URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
    Class sysclass = URLClassLoader.class;

    try {
        Method method = sysclass.getDeclaredMethod("addURL", parameters);
        method.setAccessible(true);
        method.invoke(sysloader, new Object[] {u});
    } catch (Throwable t) {
        t.printStackTrace();
    }

}