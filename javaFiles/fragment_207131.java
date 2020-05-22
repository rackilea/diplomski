class Example {
    private final int x;

    Example() {
        CompletableFuture<Integer> f = new CompletableFuture();
        asyncFunc(f::complete);
        x = f.join();
    }
}