Iterator<String> data = ImmutableList.of("1", "2", "3").iterator();
Flux<String> stringFlux = Flux.create(emmiter -> {
    while (data.hasNext()) {
        emmiter.next(data.next());
    }
    emmiter.complete();
});

stringFlux.doOnComplete(() -> System.out.println("stringFlux.doOnComplete()"))
        .subscribe(s -> System.out.println("subscribe: data: " + s), error -> {})
        .dispose();

stringFlux.publish().connect();