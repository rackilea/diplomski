CompletableFuture<ServletRsp> future = CompletableFuture.supplyAsync(() -> {
    try {
        return webservice.send(new ServletReq(date));
    } catch (SpecificException e) {
        return null;
    }
});