List<Map<String, Object>> data = readData(); // <1>

Streams.from(data)
       .flatMap(m -> Streams.just(m)
                            .dispatchOn(Environment.cachedDispatcher()) // <2>
                            .map(ignored -> Thread.currentThread().getName()))
       .buffer() // <3>
       .consume(s -> System.out.println("s: " + s)); // <4>