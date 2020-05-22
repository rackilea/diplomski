ConnectableFlux<Integer> publish1 = Flux.just(2)
        .publish()
        .autoConnect() // or .autoConnect(0)
        .doOnNext(System.out::println)
        .publish();

publish1.subscribe(System.out::println, System.out::println, System.out::println);
publish1.connect();