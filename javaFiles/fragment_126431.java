public boolean isSuperclass(final String className1, final String className2)
{
    //build a URL Class Loader
    final String[] classPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(iJavaProject);
    final List<URL> urlList = new ArrayList<URL>();
    for (int i = 0; i < classPathEntries.length; i++)
    {
        final String entry = classPathEntries[i];
        final IPath path = new Path(entry);
        final URL url = path.toFile().toURI().toURL();
        urlList.add(url);
    }
    final ClassLoader parentClassLoader = iJavaProject.getClass().getClassLoader();
    final URL[] urls = urlList.toArray(new URL[urlList.size()]);
    final URLClassLoader classLoader = new URLClassLoader(urls, parentClassLoader);

    // check if is superclass
    final Class<?> class1 = Class.forName(className1, true, classLoader);
    final Class<?> class2 = Class.forName(className2, true, classLoader);
    return class1.isAssignableFrom(class2);
}