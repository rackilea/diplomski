URL[] urls = null;
try {
    // Convert the file object to a URL
    File dir = new File(System.getProperty("user.dir")
        +File.separator+"dir"+File.separator);
    URL url = dir.toURL();        // file:/c:/almanac1.4/examples/
    urls = new URL[]{url};
} catch (MalformedURLException e) {
}

try {
    // Create a new class loader with the directory
    ClassLoader cl = new URLClassLoader(urls);

    // Load in the class
    Class cls = cl.loadClass("MyReloadableClassImpl");