class ConsumerVerticle extends AbstractVerticle {
    // this service is injected somehow, for example as constructor parameter
    private MyService service;
    ...
    public void start() {
        vertx.eventBus().consumer("address", handler -> {
            service.methodMayFail();
        });
    }
}