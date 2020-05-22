private void handleSo(RoutingContext routingContext) {

        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //make 10 async calls
            futures.add(loadFromDb()
              .map(new Function<String, JsonObject>() {
                  @Override
                  public JsonObject apply(String fromDb) {
                      return new JsonObject().put("data", fromDb);
                  }
              }));
        }
        CompositeFuture.all(futures)
          .map(new Function<CompositeFuture, JsonArray>() {
              @Override
              public JsonArray apply(CompositeFuture compositeFuture) {
                  JsonArray array = new JsonArray();
                  List<JsonObject> jsons = compositeFuture.result().list();
                  jsons.forEach(jsonObject -> array.add(jsonObject));
                  return array;

              }
          })
          .setHandler(new Handler<AsyncResult<JsonArray>>() {
              @Override
              public void handle(AsyncResult<JsonArray> res) {
                  routingContext.response().end(res.result().toString());
              }
          });
    }