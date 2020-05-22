completableFuture.complete(startOyster(oysterName));
    });
    try {
        return completableFuture.get();
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }