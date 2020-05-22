public void myFunc() throws ServerException {
    // Some code
    CompletableFuture<A> a = CompletableFuture.supplyAsync(() -> {
        try { return someObj.someFunc(); }
        catch(ServerException ex) { throw new CompletionException(ex); }
    });
    // Some code running in parallel to someFunc()

    A resultOfA;
    try {
        resultOfA = a.join();
    }
    catch(CompletionException ex) {
        try {
            throw ex.getCause();
        }
        catch(Error|RuntimeException|ServerException possible) {
            throw possible;
        }
        catch(Throwable impossible) {
            throw new AssertionError(impossible);
        }
    }
    // some code using resultOfA
}