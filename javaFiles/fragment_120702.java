private Map<Integer, String> deduplicateValues(Map<Integer, String> map) {
    Map<String, Integer> inverse = map.entrySet().stream().collect(toMap(
            Map.Entry::getValue,
            Map.Entry::getKey,
            Math::max) // take the highest key on duplicate values
    );

    return inverse.entrySet().stream().collect(toMap(Map.Entry::getValue, Map.Entry::getKey));
}