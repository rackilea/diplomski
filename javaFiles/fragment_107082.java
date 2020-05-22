Map<String, String> result = map.entrySet()
                                .stream()
                                .collect(toMap(
                                    Map.Entry::getKey, 
                                    e -> e.getValue().stream().collect(joining("|")))
                                );