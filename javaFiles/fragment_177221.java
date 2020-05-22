public static void main(String[] args) {
    CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> numberSupplier());
    future.thenAccept(i -> System.out.println("f: " + i + " - " + Thread.currentThread()));
    sleep(100); //wait for async operations to finish before exiting
}

private static Integer numberSupplier() {
    Integer n = 2;
    System.out.println("c: " + n + " - " + Thread.currentThread());
    sleep(19);
    return n;
}

private static void sleep(int millis) {
    try {
        Thread.sleep(millis);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}