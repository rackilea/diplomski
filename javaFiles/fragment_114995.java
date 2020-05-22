private static Future<Void> deployVerticle2(DeploymentOptions options) {
    Future<Void> future = Future.future();

    vertx.deployVerticle(PostgreSQLClientVerticle.class.getName(), options, deployResult -> {
      if (deployResult.failed()){
        future.fail(deployResult.cause());
      }else {
        future.complete();
      }
    });

    return future;
  }