Map<Integer, Double> collect = START.entrySet()
        .stream()
        .collect(
            Collectors.toMap(
                Map.Entry::getKey, 
                e -> e.getValue()
                      .values()
                      .stream()
                      .reduce(0d, (a, b) -> a + b)
                )
        );