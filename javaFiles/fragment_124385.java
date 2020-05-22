static Map<String,Set<String>> makeUnmodifiable(Map<String,Set<String>> m) {
  Map<String,Set<String>> map = new HashMap<String,Set<String>>();
  for (Map.Entry<String,Set<String>> entry : m.entrySet()) {
    map.add(entry.getKey(), Collections.unmodifiableSet(entry.getValue()));
  }
  return Collections.unmodifiableMap(map);
}

static class Pair {
  final String first;
  final Map<String,Set<String>> second;
  Pair(String first, Map<String,Set<String>> second) {
    this.first = first;
    this.second = second != null ? makeUnmodifiable(second) : null;
  }
  public void equals(Object o) {
    ...
  }
  public int hashCode() {
    ...
  }
}

Map<Pair,Set<Subscriber>> myMap;