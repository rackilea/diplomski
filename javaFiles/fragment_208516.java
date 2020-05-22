Mono.create(sink -> {
    AtomicBoolean once = new AtomicBoolean();
    sink.onRequest(__ -> {
        if(!once.get() && once.compareAndSet(false, true) {
            myAsyncHttpClient.execute(someData, (result, exception -> {
                if(exception != null) {
                    sink.error(exception);
                    return;
                }
                sink.success(result);
            });
        }
    });
});