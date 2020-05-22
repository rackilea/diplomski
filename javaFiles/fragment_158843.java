Mono<Baz> getBazRx(Foo foo) {
    return Mono.fromSupplier(() -> {
            try {
                return getBaz(foo);
            } catch (IOException e) {
                throw Exceptions.propagate(e);  // or return null to ignore and complete empty
            }
        })
        .subscribeOn(Schedulers.elastic());  // run on a scheduler suitable for blocking work
}