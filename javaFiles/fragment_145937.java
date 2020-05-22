public Stream<CompletableFuture<String>> findPricesStream(String product) {
    return shops.stream().map(
        shop -> CompletableFuture
            .supplyAsync(() -> shop.getPrice(product), executor)
            .thenApply(Quote::parse)
            .thenApplyAsync(quote -> Discount.applyDiscount(quote), executor));
}