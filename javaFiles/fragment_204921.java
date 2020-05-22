// URL class loader to lookup in jars etc
private static class MyClassLoader extends URLClassLoader
{
    public MyClassLoader(URL[] urls) {
        // Use the given URLs and skip any parent class loader, directly go to the system loader
        super(urls,null);
    }

// ...

// Then setup the class path
    String[] classPath = System.getProperty("java.class.path").split(";");
    URL[] classPathUrls = new URL[classPath.length];
    for (int i = 0; i < classPath.length; i++) {
        classPathUrls[i] = new File(classPath[i]).toURL();

    }
    MyClassLoader loader = new MyClassLoader(classPathUrls);