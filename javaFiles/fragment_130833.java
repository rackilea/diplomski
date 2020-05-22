@GetMapping("/getflux")
public Flux<List<StringWrapper>> getFlux() {
    return Flux.fromIterable(
        Arrays.asList(
            new StringWrapper( "String 1" ),
            new StringWrapper( "String 2" )

        )
    );
}