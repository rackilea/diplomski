public <T> Mono<T> doWithConnection(Function<String, Mono<T>> callback, long timeout) {
    return Mono.using(
            //the resource supplier:
            () -> {
                System.out.println("connection acquired");
                return "hello";
            },
            //create a Mono out of the resource. On any termination, the resource is cleaned up
            connection -> Mono.just(connection)
                              //the blocking callable needs own thread:
                              .publishOn(Schedulers.single())
                              //execute the callable and get result...
                              .then(callback::apply)
                              //...but cancel if it takes too long
                              .timeoutMillis(timeout)
                              //for demonstration we'll log when timeout triggers:
                              .doOnError(TimeoutException.class, e -> System.out.println("timed out")),
            //the resource cleanup:
            connection -> System.out.println("cleaned up " + connection));
}