//This yields a Map<String, List<String>>
entries.stream()
    .flatMap(v -> v.values.stream().map(val -> new SimpleEntry<>(v.key, val)))
    .collect(Collectors.groupingBy(
        Map.Entry::getKey, 
        Collectors.mapping(Map.Entry::getValue, 
                           Collectors.toList())));