Future<...> callAFuture = Future.future();
callA(asyncResultA -> {
  if (asyncResultA.succeeded()) {
    System.out.println("A finished!");
    callAFuture.complete(asyncResultA.result());
  } else {
    callAFuture.fail(asyncResultA.cause());
  }
});