private CompletableFuture<Void> getAndAcceptAsync(Consumer<List<?>> resultProcessor) {  
    return CompletableFuture.supplyAsync(() -> {
        List<SomePojo> somePojos = null;
        try {
            somePojos = someServiceThatThrowsException.getAll(SomePojo.class);
        } catch (SomeException e) {
           //Handle the exception
           e.printStackTrace();
        } 
        return somePojos; 
    }).thenAcceptAsync(resultProcessor);
}