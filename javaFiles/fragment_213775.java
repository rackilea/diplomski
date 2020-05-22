Map<String, List<String>> result1 = Arrays.stream(testPairs)
    .collect(Collectors.groupingBy(Pair::getS, 
        Collectors.mapping(Pair::getT, Collectors.toList())));

Map<String, String> result2 = Arrays.stream(testPairs)
    .collect(Collectors.toMap(Pair::getS, Pair::getT, (v1, v2) -> v1));