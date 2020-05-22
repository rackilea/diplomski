ResourceManager rm = new PathResourceManager(Paths.get("/path/to/your/folder"));
Resource r = rm.getResource("index.html");
Undertow.builder()
    .addHttpListener(8080, "0.0.0.0")
    .setHandler(Handlers.predicate(
        ex -> ex.getRequestMethod().equals(Methods.GET),
        ex -> r.serve(ex.getResponseSender(), ex, IoCallback.END_EXCHANGE),
        ResponseCodeHandler.HANDLE_405)
    ).build().start();