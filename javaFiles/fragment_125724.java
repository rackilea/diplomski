@Override
  public void start() throws Exception {
    // Set up the handler for the web application context.
    WebAppContext root = new WebAppContext();
    root.setExtraClasspath(extraClassPath);
    root.setDescriptor(new File(appDir, "WEB-INF/web.xml").getAbsolutePath());
    root.setWar(new File(appDir).getAbsolutePath());
    root.setContextPath(contextPath);
    root.setParentLoaderPriority(true);
    server.setHandler(root);
    server.start();
    System.out.println("Jetty server is started!");
  }