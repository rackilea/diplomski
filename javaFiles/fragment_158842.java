Mono<Baz> getBazRx(Foo foo) {
    // BAD!!!
    try {
        return Mono.just(getBaz(foo));
    } catch (IOException e) {
        return Mono.error(e)  // or Mono.empty() if you want to ignore
    }
}