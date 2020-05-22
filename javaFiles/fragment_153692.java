Flux<Integer> flux1 = Flux.<Integer>generate(emitter -> emitter.next(1))
        .subscribeOn(Schedulers.elastic());

Flux<Integer> flux2 = Flux.<Integer>generate(emitter -> emitter.next(2))
        .subscribeOn(Schedulers.elastic());

Flux<Integer> merged = flux1.mergeWith(flux2);
merged.subscribe(s -> System.out.println(s));

Thread.currentThread().join();