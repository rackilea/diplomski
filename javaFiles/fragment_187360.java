List<Map<String, Integer>> temporaryResult = myMap.values()
            .stream()
            .map(a -> a.entrySet()
                    .stream()
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            c -> c.getValue().size()))
            )
            .collect(Collectors.toList());