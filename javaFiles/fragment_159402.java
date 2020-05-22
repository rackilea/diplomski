public CompletableFuture<Integer> printEvenOrOdd(int result) {
    return CompletableFuture.supplyAsync(() -> {
        System.out.println(result % 2 == 0 ? "Even" : "Odd");
        return result;
    });
}