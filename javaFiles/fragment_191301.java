ContextHandlerCollection handlers = new ContextHandlerCollection();
    handlers.setHandlers(new Handler[] {context, new DefaultHandler()});
    server.setHandler(handlers);
    server.start();
    System.out.println("Server ready...");
    server.join();