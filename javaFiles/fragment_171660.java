AbderaClient client;
ClassLoader originalClassLoader = Thread.currentThread().getContextClassLoader();
try {
    ClassLoader cl = this.getClass().getClassLoader();
    Thread.currentThread().setContextClassLoader(cl);

    Abdera abdera = new Abdera();
    client = new AbderaClient(abdera);

    // Do something with client

} finally {
    // Restore original classloader
    Thread.currentThread().setContextClassLoader(originalClassLoader);
}