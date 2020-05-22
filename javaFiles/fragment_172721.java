public Result execute(Query query) throws InterruptedException {
    int id = atomicInteger.incrementAndGet();
    ResultFuture resultFuture = new ResultFuture();
    resultFutureMap.put(id, resultFuture);
    query.executeAsyncWithId(id); // Probably returns before result is ready
    try {
        return resultFuture.get(); // Blocks until result is ready
    } finally {
        resultFutureMap.remove(id);
    }
}

public void handleResult(Result result) {
    int id = result.getId();
    ResultFuture resultFuture = resultFutureMap.get(id);
    if (resultFuture == null) {
        return; // Nobody wants result
    }
    resultFuture.set(result);
}