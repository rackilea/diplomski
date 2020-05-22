CompletableFuture<Void> f = CompletableFuture.runAsync(() -> {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }, Executors.newSingleThreadExecutor());
return f;