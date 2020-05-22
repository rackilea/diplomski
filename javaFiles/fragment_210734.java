private void handleSo(RoutingContext routingContext) {

    loadFromDb()
      .map(new Function<String, JsonArray>() {
          @Override
          public JsonArray apply(String fromDb) {
              //map to json
              return new JsonArray(...);
          }
      })
      .setHandler(
        new Handler<AsyncResult<JsonArray>>() {
            @Override
            public void handle(AsyncResult<JsonArray> result) {
                routingContext.response().end(result.result().toString());
            }
        }
      );
}