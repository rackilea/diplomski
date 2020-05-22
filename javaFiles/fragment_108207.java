Map<String,Map<String,String>> testMap = testSet
        .stream()
        .collect(
                Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> Map.ofEntries(entry(entry.getKey(),entry.getValue() + "2"))
                )
        );