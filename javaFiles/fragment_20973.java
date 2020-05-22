public Optional<String> zipString(String a, String b) {
    if (a.equals("B"))
        return Optional.empty();
    return Optional.of(a + b);
}

Flux.zip(flux1, flux2, this::zipString)
    .filter(Optional::isPresent)
    .map(Optional::get)
    .subscribe(System.out::println);