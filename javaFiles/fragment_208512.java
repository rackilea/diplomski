public CompletableFuture myNonBlockingHttpCall(Object someData) {
    var uncompletedFuture = new CompletableFuture(); // creates uncompleted future

    myAsyncHttpClient.execute(someData, (result, exception -> {
        if(exception != null) {
            uncompletedFuture.completeExceptionally(exception);
            return;
        }
        uncompletedFuture.complete(result);
    })

    return uncompletedFuture;
}