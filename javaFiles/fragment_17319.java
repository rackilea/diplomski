File file = new File("/path/resource1.jar");
    URL url = file.toURI().toURL();
    URL[] urls = new URL[]{url};
    ClassLoader cl = new URLClassLoader(urls, Main.class.getClassLoader());

    ResourceConfig rc = new ResourceConfig()
            .setClassLoader(cl)
            .files("/path/resource1.jar");
    HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(
            BASE_URI, rc);