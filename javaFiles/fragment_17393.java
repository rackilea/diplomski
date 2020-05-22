AtomicInteger generateElements = new AtomicInteger(0);

Flux.generate(emitter -> emitter.next(generateElements.getAndIncrement()))
    .subscribeOn(Schedulers.elastic())
    .take(4)
    .subscribe(System.out::println);