private static Future<Void> loadTestData2(JDBCClient jdbc){
    Future<Void> future = Future.future();

    jdbc.getConnection(connection -> {
      if (connection.succeeded()) {
        connection.result().query(deleteTestDataGeneration, queryResult -> {
          if(queryResult.failed()){
            connection.result().close();
            future.fail(queryResult.cause());
          }else{
            connection.result().close();
            future.complete();
          }
        });
      } else {
        future.fail(connection.cause());
      }
    });

    return future;
  }