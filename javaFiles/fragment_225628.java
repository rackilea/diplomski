private void someMethod(Handler<Result> resultHandler) {
  ...
  vertx.eventBus().<JsonObject>send(Service.EVENT_BUS_ADDRESS, json, ar -> {
            if (ar.succeeded()) {
                var result = new Result<List>(ar.result().body());
                if (result.isSuccessful()) {
                    resultHandler.handle(Result.succeed(result));
                } else {
                    resultHandler.handle(Result.fail(result.message));
                }
            } else {
                resultHandler.handle(Result.fail("Remote server error"));
            }
  ...
}