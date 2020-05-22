public static Map<String, Values> mergeMaps(List<Map<String, Values>> maps) {
    return maps.stream()
               .flatMap(m -> m.entrySet().stream())
               .collect(Collectors.toMap(Map.Entry::getKey,
                                         Map.Entry::getValue,
                                         (v1,v2) -> new Values(v1,v2)));
}