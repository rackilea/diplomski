CompletableFuture<Rep> result = new CompletableFuture<>();
    CompletableFuture.runAsync(() -> {

        transporter.write(req);
        try {
            Rep rep = responseQueue.take();
            result.complete(rep);
        } catch (InterruptedException e) {
            result.completeExceptionally(e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            result.completeExceptionally(e);
        }

    }, executorService);
    return result;