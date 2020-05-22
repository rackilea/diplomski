private static final Pattern COMMA_DELIMITER = Pattern.compile(",\\s*");

Map<String, Set<Coordinate>> nameToCoordinates = coordinates.stream()
    .flatMap(
        c -> COMMA_DELIMITER.splitAsStream(c.getName())
            .map(n -> new Coordinate(n, c.getX(), c.getY())))
    .collect(Collectors.groupingBy(Coordinate::getName, Collectors.toSet()));