int minKeyWithMaxValueEntry = map.entrySet()
        .stream()
        .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, 
                Integer::min, TreeMap::new))
        .lastEntry()
        .getValue();