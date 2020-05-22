public static CompletionStage<String> calculateAsync()  {
    CompletableFuture<String> completableFuture = new CompletableFuture<>();
    Executors.newCachedThreadPool().submit(() -> {
        Thread.sleep(5000);
        completableFuture.complete("Hello");
        return null;
    });
    return completableFuture;
}

public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    Router router = Router.router(vertx);
    Router.router(vertx).get("/api").handler(ctx -> {
        calculateAsync().whenComplete((result, e) -> vertx.runOnContext(none -> {
            ctx.response().end(result);
        }));

    });
    vertx.createHttpServer().requestHandler(router::accept).listen(8080);
}