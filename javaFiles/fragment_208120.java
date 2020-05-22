Server server = new Server(8080);

    // Figure out what path to serve content from
    ClassLoader cl = WebAppContextFromClasspath.class.getClassLoader();
    // We look for a file, as ClassLoader.getResource() is not
    // designed to look for directories (we resolve the directory later)
    URL f = cl.getResource("hello.html");
    if (f == null)
    {
        throw new RuntimeException("Unable to find resource directory");
    }

    // Resolve file to directory
    URI webRootUri = f.toURI().resolve("./").normalize();
    System.err.println("WebRoot is " + webRootUri);

    WebAppContext webapp = new WebAppContext();
    webapp.setContextPath("/");
    webapp.setWar(webRootUri.toASCIIString());
    webapp.setParentLoaderPriority(true);

    server.setHandler(webapp);

    server.start();
    server.join();