Map<String, Long> toMap(Stream<Map<String, Long>> stream) {
    return stream.flatMap (map -> map.entrySet().stream()) // this would create a flattened
                                                           // Stream of all the map entries
                 .collect(Collectors.toMap(e -> e.getKey(),
                                           e -> e.getValue())); // this should collect
                                                               // them to a single map
}