@Override
public void start() throws Exception {

    HttpServer server = vertx.createHttpServer();

    Router router = Router.router(Vertx.vertx());
    router.route().handler(BodyHandler.create());

    // Bind "/" to our hello message - so we are still compatible.
    router.route("/").handler(routingContext -> {
        HttpServerResponse response = routingContext.response();
        response
            .putHeader("content-type", "text/html")
            .end("<h1>Hello from my first Vert.x 3 application</h1>");
    });

    router.route("/callme*").handler(BodyHandler.create());
    router.post("/callme").handler(this::divide);

        server.requestStream().toObservable().subscribe(req -> {
         HttpServerResponse res = req.response();
         res.putHeader("content-type", "text/html");
         res.end("Hi there, from rx verticle!");
     });

         vertx
        .createHttpServer()
        .requestHandler(router::accept)
        .rxListen(8090)
        .subscribe(httpServer -> logger.info("server is running..."));
}