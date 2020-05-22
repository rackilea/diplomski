Function<String[], OptionalInt> funct = keys -> Arrays.stream(keys)
    .map(metadata::get)
    .filter(Objects::nonNull)
    .map(v -> v.replace("pixels", ""))
    .mapToInt(Integer::parseInt)
    .findFirst();