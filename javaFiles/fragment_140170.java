ContextHandlerCollection contexts = new ContextHandlerCollection();
    contexts.addHandler(new ContextHandler(wsFooHandler, "/foo"));
    contexts.addHandler(new ContextHandler(wsBarHandler, "/bar"));

    HandlerList handlers = new HandlerList();
    handlers.setHandlers(new Handler[] { resource_handler, contexts, new DefaultHandler() });