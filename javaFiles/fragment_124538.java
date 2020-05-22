public NewClass() {
    theData = someFluxService.get()
            .collectMap(Data::getId, Function.identity())
            .cache(Duration.ofMinutes(5));
}

public Mono<Map<String, Data>> getTheData() {
    return theData;
}