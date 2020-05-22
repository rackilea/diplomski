Map<String, List<? extends Foobar>> maps = ...;
Map<String, List<? extends Foobar>> copy = ...;
for (Map<String, List<? extends Foobar>> entry : maps.entrySet()) {
  copy.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
}
Map<String, List<? extends Foobar>> unmodifiableMap =     Collections.unmodifiableMap(copy);