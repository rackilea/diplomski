out = IntStream
        .range(1, 10)
        .filter(e -> e % 2 == 0)
        .map(e -> 2 * e)
        .boxed()
        .collect(Collectors.toList());