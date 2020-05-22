public CompletableFuture myUpperLevelBusinessLogic() {
    var future = myNonBlockingHttpCall();

    // ... some code

    if (something) {
       // oh we don't really need anything, let's just throw an exception
       var errorFuture = new CompletableFuture();
       errorFuture.completeExceptionally(new RuntimeException());

       return errorFuture;
    }

   return future;
}