List<Future<String>> listFuturesT = new ArrayList<>();
    // This works
    MyCompositeFuture.all(listFuturesT);

    List<Future> listFutures = new ArrayList<>();
    // This doesnt, and that's the reason for initial design decision
    MyCompositeFuture.all(listFutures);