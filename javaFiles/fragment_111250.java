ConnectableFlux<Integer> publish = Flux.just(1)
        .publish();

ConnectableFlux<Integer> publish1 = Flux.just(2)
        .flatMap(x -> publish)
        .publish();

publish1.subscribe(System.out::println, System.out::println, System.out::println);
publish1.connect();
publish.connect();