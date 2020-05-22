Flux.interval(Duration.ofSeconds(1))
    .doOnNext(__ -> System.out.println("producing number: " + __))
    .publish()
    .autoConnect()
    .doOnNext((Integer __) -> {
        System.out.println("throwing error.");
        throw new RuntimeException("aaa");
    })
    .retry(1)
    .subscribe()