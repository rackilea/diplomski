public static ClassLoader createClassLoader(String dirname) throws java.io.IOException {
    java.net.URL[] url = new java.net.URL[1];
    java.io.File file;
    if (dirname.endsWith("/")) {
        file = new java.io.File(dirname);
    }
    else {
        file = new java.io.File(dirname + "/");
    }
    url[0]= file.toURI().toURL();

    ClassLoader parent = ClassLoader.getSystemClassLoader();
    java.net.URLClassLoader loader = new java.net.URLClassLoader(url, parent);
    return loader
}