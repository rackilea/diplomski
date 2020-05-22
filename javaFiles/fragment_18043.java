private static List<Map.Entry<String, AtomicInteger>> sortedEntries(
        Map<String, AtomicInteger> map) {
    return map.entrySet()
        .stream()
        .sorted(Comparator.comparingInt(entry -> entry.getValue().get()))
        .collect(Collectors.toList());
}