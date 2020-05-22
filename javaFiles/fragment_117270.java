public Map<String, Map<String, Object>> getAllValuesInParallel2(RequestObj requestObj) {

    Map<String, Map<String, Object>> response = new HashMap<>();
    ExecutorService executor = Executors.newFixedThreadPool(6);
    CompletableFuture<List<Map<String, Object>>> myFuture1 = CompletableFuture.supplyAsync(() -> {
        List<Template> keys = new ArrayList<>();
        keys.add("mani");
        return aClient.transform(keys, requestObj);
    }, executor);

    CompletableFuture<List<Map<String, Object>>> myFuture2 = CompletableFuture.supplyAsync(() -> {
        List<Template> keys = new ArrayList<>();
        keys.add("gani");
        return bClient.transform(keys, requestObj);
    }, executor);

    CompletableFuture<List<Map<String, Object>>> myFuture3 = CompletableFuture.supplyAsync(() -> {
        List<Template> keys = new ArrayList<>();
        keys.add("priya");
        return cClient.transform(keys, requestObj);
    }, executor);

    CompletableFuture<List<Map<String, Object>>> myFuture4 = CompletableFuture.supplyAsync(() -> {
        List<Template> keys = new ArrayList<>();
        keys.add("ravi");
        return dClient.transform(keys, requestObj);
    }, executor);

    Stream.of(myFuture1, myFuture2, myFuture3, myFuture4)
        .map(CompletableFuture::join)
        .filter(Objects::nonNull)
        .forEachOrdered(s -> putIntoResponse(response, s));


    return response;
}