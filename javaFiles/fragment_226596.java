public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture<Result> completableFuture = CompletableFuture
            .supplyAsync(() -> {
                System.out.println("Making call to API...");
                //call API here and if call fails, throw exception
                //throw new RuntimeException("HTTP call failed");
                return new Result(true, "Done");
            })
            .handle((o, throwable) -> o.isSuccess() ? o : new Result(false, throwable.getMessage()));

    Executors.newSingleThreadScheduledExecutor()
            .schedule(() -> {
                        Result result = completableFuture.getNow(new Result(false, "Timeout"));
                        System.out.println("Log to DB: "
                                + result.isSuccess()
                                + result.getMessage());
                        //other application method calls here
                    }, 7, TimeUnit.SECONDS);
}