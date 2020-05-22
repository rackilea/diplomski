public Future<String> doSomethingAsync() {
  Future<String> callAFuture = Future.future();

  // do the async stuff
  callA(asyncResultA -> {
    if (asyncResultA.succeeded()) {
      System.out.println("A finished!");
      callAFuture.complete(asyncResultA.result());
    } else {
      callAFuture.fail(asyncResultA.cause());
    }
  });

  // return Future with the asyncResult of callA
  return callAFuture;
}