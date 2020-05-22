@Override
public int size() {
  return keySet().size();
}

@Override
public boolean isEmpty() {
  return !chain.stream().filter(map -> !map.isEmpty()).findFirst().isPresent();
}

@Override
public boolean containsKey(Object key) {
  return chain.stream().filter(map -> map.containsKey(key)).findFirst().isPresent();
}

@Override
public boolean containsValue(Object value) {
  return entrySet().stream()
    .filter(e -> value == e.getValue() || (value != null && value.equals(e.getValue())))
    .findFirst().isPresent();
}

@Override
public V get(Object key) {
  return chain.stream().filter(map -> map.containsKey(key))
    .findFirst().map(map -> map.get(key)).orElse(null);
}