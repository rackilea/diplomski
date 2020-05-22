Flux.range(1, 5).hide()
    .flatMap(v -> Flux.range(v * 10, 2)
                      .publishOn(Schedulers.newParallel("foo", 3)))
    .flatMap(v -> Flux.range(10 * v, 2))
    .log()
    .blockLast(); //for test purpose