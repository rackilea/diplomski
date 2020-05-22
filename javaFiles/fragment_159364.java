@Test
public void reactiveParser() throws InterruptedException {
    ConnectableFlux<String> letters = Flux.create((Consumer<? super FluxSink<String>>) t -> {
        char[] chars = "sfdsfsdf/sdf/sdfs/dfsdfsd/fsd/fsd/fs/df/sdf".toCharArray();
        for (char c : chars) {
            t.next(String.valueOf(c));
        }
    }).publish();

    letters
            .window(
                    letters.filter( t -> t.equals("/"))
            )
            .flatMap( t -> t.collectList())
            .map( t -> t.stream().collect(Collectors.joining()))
            .subscribe(t -> {
                System.out.println(t);
            });

    letters.connect();
}