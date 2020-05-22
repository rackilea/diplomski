private static Map<Integer, String> sorted() {
    return map.entrySet()
            .stream()
            .sorted(Comparator.comparing(Entry::getValue))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
}