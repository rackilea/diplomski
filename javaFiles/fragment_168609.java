final int port = 5040;
    final int sslPort = 8442;

    server = new Server(port);

    SslContextFactory contextFactory = new SslContextFactory();
    contextFactory.setKeyStorePath("/Users/me/keystore");
    contextFactory.setKeyStorePassword("password");
    SslConnectionFactory sslConnectionFactory = new SslConnectionFactory(contextFactory, org.eclipse.jetty.http.HttpVersion.HTTP_1_1.toString());

    HttpConfiguration config = new HttpConfiguration();
    config.setSecureScheme("https");
    config.setSecurePort(sslPort);
    config.setOutputBufferSize(32786);
    config.setRequestHeaderSize(8192);
    config.setResponseHeaderSize(8192);
    HttpConfiguration sslConfiguration = new HttpConfiguration(config);
    sslConfiguration.addCustomizer(new SecureRequestCustomizer());
    HttpConnectionFactory httpConnectionFactory = new HttpConnectionFactory(sslConfiguration);

    ServerConnector connector = new ServerConnector(server, sslConnectionFactory, httpConnectionFactory);

    connector.setPort(sslPort);
    server.addConnector(connector);

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");

    try
    {
        // Add websocket servlet
        ServletHolder wsHolder = new ServletHolder("ws-echo", new EchoSocketServlet());
        context.addServlet(wsHolder,"/echo");

        server.setHandler(context);

        server.start();
        server.dump(System.err);
        server.join();
    }
    catch (Throwable t)
    {
        t.printStackTrace(System.err);
    }