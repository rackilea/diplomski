public void executeImplementationsOfAInJarFile(File downloadedJarFile)
{
    If (downloadedJarFile == null || !downloadedJarFile.exists())
        throw new IllegalArgumentException("Invalid jar file provided");

    URL downloadURL = downloadedJarFile.toURI().toURL();
    URL[] downloadURLs = new URL[] { downloadURL };
    URLClassLoader loader = URLClassLoader.newInstance(downloadURLs, getClass().getClassLoader());
    try
    {
        List<Class<?>> implementingClasses = findImplementingClassesInJarFile(downloadedJarFile, A.class, loader);
        for (Class<?> clazz : implementingClasses)
        {
            // assume there is a public default constructor available
            A instance = clazz.newInstance();
            // ... do whatever you like here
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}