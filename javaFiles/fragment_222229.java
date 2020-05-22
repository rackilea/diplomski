return source.stream()
    .allMatch(this::isEdible)
    ? source.stream()
        .map(this::prepare()) // do stuff
        .collect(Collectors.toList())
    : Collections.emptyList();