Map<Key1, CustomObject> map = 
    inputMap.entrySet()
            .stream()
            .filter(e -> e.getValue().containsKey("a string"))
            .collect(Collectors.toMap(Map.Entry::getKey,
                                      e -> e.getValue().get("a string")));