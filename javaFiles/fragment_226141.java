public Optional<Integer> m(Ws wsObject) {
    return Optional.ofNullable(wsObject.getFoo()) // Here you get Optional.empty() if the Foo is null
        .map(f -> f.getBar()) // Here you transform the optional or get empty if the Bar is null
        .map(b -> b.getBaz())
        .map(b -> b.getInt());
        // Add this if you want to return an -1 int instead of an empty optional if any is null
        // .orElse(-1);
        // Or this if you want to throw an exception instead
        // .orElseThrow(SomeApplicationException::new);
}