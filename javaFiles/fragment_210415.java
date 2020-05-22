public void myFunc() throws ServerException {
    // Some code
    CompletableFuture<ServerException> exception = new CompletableFuture<>();
    CompletableFuture<A> a = CompletableFuture.supplyAsync(() -> {
        try { return someObj.someFunc(); }
        catch(ServerException ex) {
            exception.complete(ex);
            throw new CompletionException(ex);
        }
    });
    // Some code running in parallel to someFunc()

    A resultOfA;
    try {
        resultOfA = a.join();
    }
    catch(CompletionException ex) {
        if(exception.isDone()) throw exception.join();
        throw ex;
    }

    // some code using resultOfA
}