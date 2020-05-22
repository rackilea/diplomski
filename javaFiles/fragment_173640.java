Server server = new Server();

    // Note: if you don't want control over type of connector, etc. you can simply 
    // call new Server(<port>);
    ServerConnector connector = new ServerConnector(server);
    connector.setHost("0.0.0.0");
    connector.setPort(8085);
    // Setting the name allows you to serve different app contexts from different connectors.
    connector.setName("main");
    server.addConnector(connector);

    WebAppContext context = new WebAppContext();
    context.setContextPath("/");
    // For development within an IDE like Eclipse, you can directly point to the web.xml
    context.setWar("src/main/webapp");
    context.addFilter(MyFilter.class, "/", 1);

    HandlerCollection collection = new HandlerCollection();
    RequestLogHandler rlh = new RequestLogHandler();
    // Slf4j - who uses anything else?
    Slf4jRequestLog requestLog = new Slf4jRequestLog();
    requestLog.setExtended(false);
    rlh.setRequestLog(requestLog);
    collection.setHandlers(new Handler[] { context, rlh });
    server.setHandler(collection);

    try {
        server.start();
        server.join();
    } catch (Exception e) {
        // Google guava way
        throw Throwables.propagate(e);
    }