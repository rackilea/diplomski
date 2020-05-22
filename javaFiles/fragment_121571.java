Mono<String> oneMono = Mono.just("1");
Mono<String> twoMono = Mono.just("2");

Mono.zip(oneMono, twoMono, (one, two) -> {
    Mono<String> threeMono = Mono.just("3");
    Mono<String> fourMono = Mono.just("4");

    return Mono.zip(threeMono, fourMono, (three, four) -> {
        return "5";
    });
})
.flatMap(stringMono -> stringMono)
.doOnNext(System.out::println)
.subscribe();