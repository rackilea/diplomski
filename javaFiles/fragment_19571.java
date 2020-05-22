public static <T> CompletableFuture<T> failedFuture(Throwable ex) {
    // copied from Java 9 https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/CompletableFuture.html#failedFuture(java.lang.Throwable)
    CompletableFuture<T> f = new CompletableFuture<>();
    f.completeExceptionally(ex);
    return f;
}

CompletableFuture<ResponseType> failure = failedFuture(new InterruptedException());