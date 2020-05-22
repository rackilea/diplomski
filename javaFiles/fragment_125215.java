final ListeningExecutorService service1 = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(16));
final ListeningExecutorService service2 = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(16));

ListenableFuture<String> service1result = service1.submit(new Callable<String>() {
    @Override
    public String call() throws Exception {
        return "service1result";
    }
});

ListenableFuture<String> service2result = Futures.chain(service1result, new Function<String, ListenableFuture<String>>() {
    @Override
    public ListenableFuture<String> apply(final @Nullable String input) {
        return service2.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Joiner.on(" -> ").join(input, "service2result");
            }
        });
    }
});

System.out.format("Result: %s\r\n", service2result.get());