public static List<Entry<String, Integer>> topNKeys(Map<String, Integer> map, int n) {
  Set<Integer> topValues = getTopValues(map, n);
  return getEntriesWithTopValues(map, topValues);
}

//Returns the distinct top n values
private static Set<Integer> getTopValues(Map<String, Integer> map, int n) {
  TreeSet<Integer> values = new TreeSet<>(map.values());
  Set<Integer> topNValues = new HashSet<>();
  for (int i = 0; i < n; i++) {
    Integer v = values.pollLast();
    if (v != null) topNValues.add(v);
    else break;
  }
  return topNValues;
}

//Returns the entries with a value that is contained in topValues
private static List<Entry<String, Integer>> getEntriesWithTopValues(Map<String, Integer> map, Set<Integer> topValues) {
  return map.entrySet().stream()
          .filter(e -> topValues.contains(e.getValue()))
          .sorted(Entry.comparingByValue())
          .collect(toList());
}