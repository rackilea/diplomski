Options<String, String> foo = elems.stream()
    .collect(
        () -> options,
        (opt, pair) -> opt.add(pair.getKey(), pair.getValue()),
        (a, b) -> { throw new UnsupportedOperationException(); }
    );