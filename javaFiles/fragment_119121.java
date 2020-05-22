List<Double> doubles =
    rand.doubles()
        .distinct()
        .map(d -> 1 + d * 9)
        .limit(100)
        .boxed()
        .collect(Collectors.toList());