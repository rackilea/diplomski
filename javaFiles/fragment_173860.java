Flux<Foo> foos = dao.getAll();
Mono<List<Foo>> everything = foos.collectList();

Mono<MyRequest> request = everything
    // collect the data into another Mono, then into request
    .map(list -> list.stream().map(Foo::getData).collect(toList()))
    .map(data -> new MyRequest(data));

return request.zipWhen(request -> api.send(request));