private void generateVoucher(Handler<AsyncResult<String>> handler) {
  String myId = ....;
  client.getConnection(res -> {
    if (res.succeeded()) {
      SQLConnection connection = res.result();
      connection.queryWithParams(myQuery, new JsonArray().add(myId), res2 -> {
        if (res2.succeeded()) {
          ResultSet rs = res2.result();
          boolean inDb = checkAlreadyInDb(rs);
          connection.close();
          if (inDb) {
            generateVoucher(handler);
          } else {
            handler.handle(Future.succeededFuture(myId));
          }
        } else {
          handler.handle(Future.failedFuture(res2.cause));
        }
      });
    } else {
      handler.handle(Future.failedFuture(res.cause));
    }
  });
}