return Optional.of(
        items.stream()
             .map(s -> new B())
             .findFirst()
             .get()
    );