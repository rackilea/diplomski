private static boolean validateSMTP(final ArrayList<String> mxList, String address)
        throws ExecutionException, InterruptedException {

    ExecutorService pool = Executors.newFixedThreadPool(mxList.size());

    return mxList.stream()
            .map(mx -> createAsyncVerifier(mx, address, pool))
            .collect(Collectors.toList())
            .stream()
            .map(CompletableFuture<Boolean>::join)
            .filter(b -> b)
            .findFirst()
            .orElse(Boolean.FALSE);
}