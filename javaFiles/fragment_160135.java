ServerConnector httpConnector = new ServerConnector(server);
    httpConnector.setName("unsecured"); // named connector
    httpConnector.setPort(80);

    ContextHandler helloHandler = new ContextHandler();
    helloHandler.setContextPath("/hello");
    helloHandler.setHandler(new HelloHandler("Hello World"));
    helloHandler.setVirtualHosts(new String[]{"@unsecured"});