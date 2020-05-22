private void loadFromDb(Handler<String> handler) {
    String result = "fromDb";
    handler.handle(result);
}

 private void handleSo(RoutingContext routingContext) {
    loadFromDb(new Handler<String>() {
        @Override
        public void handle(String fromDb) {
            routingContext.response().end(new JsonArray(...).toString());
        }
    });
}