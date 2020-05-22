public Map<String, Map<String, Set<String>>> mumap(List<Record> records) {
    Map<String, Map<String, Set<String>>> result = new LinkedHashMap<>();
    for (Record r : records) {
        result.computeIfAbsent(r.region, region -> new LinkedHashMap<>())
              .computeIfAbsent(r.country, country -> new TreeSet<>())
              .add(r.city);
    }
    return result;
}