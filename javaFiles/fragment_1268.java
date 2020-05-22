public static void someAsyncCall(Item i, Callback callback) {
    CompletableFuture.runAsync( () -> { // new thread
        Result result = computeResult(i);
        callback.onSuccess(result, i);
    });
}