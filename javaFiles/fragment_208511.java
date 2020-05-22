CompletableFuture.supplyAsync(() -> {
    try {
        Thread.sleep(1000);
    }
    catch (InterruptedException e) {

    }

    return 1;
});