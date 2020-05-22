Map<String, List<String>> result1 = Arrays.stream(testPairs)
        .collect(Collectors.groupingBy(p -> (String) p.getKey(),
                Collectors.mapping(p -> (String) p.getValue(), Collectors.toList())));

Map<String, String> result2 = Arrays.stream(testPairs)
                .collect(Collectors.toMap(
                        p -> (String) p.getKey(), 
                        p -> (String) p.getValue(), 
                        (a, b) -> b)
                );
    }