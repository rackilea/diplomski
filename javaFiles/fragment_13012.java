public Map<String, Set<Item>> filterByStatus(Map<String, Set<Item>> changes) {
    return changes.entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry ->
                entry.getValue()
                    .stream()
                    .filter(item -> item.status == null || item.status == Boolean.FALSE)
                    .collect(Collectors.toSet())
            ));
}