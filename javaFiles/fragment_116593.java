CompletableFuture<ServletRsp> future = new CompletableFuture<>();
service.execute(() -> {
    try {
        future.complete(webservice.send(new ServletReq(date));
    } catch (SpecificException e) {
        future.completeExceptionally(e);
    }
});
futures.add(future);