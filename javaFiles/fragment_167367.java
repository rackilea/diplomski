CompletableFuture<ArrayList<Stock>> stocksFuture = getAllAvailableStocks(...);
stocksFuture.thenAccept((stocks) -> {
    // NOTE: This will be called after and only if the request succeeded
    stocks.forEach(x -> System.out.println(x));
});

System.out.println("This is probably executed before the above request finished.");

Thread.sleep(10000); // If you are calling from your `main` method: Prevent JVM exit