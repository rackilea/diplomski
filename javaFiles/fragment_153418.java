Stream<Map.Entry<String, String>> flatten(Map<String, Object> map) {
  return map.entrySet()
            .stream()
            .flatMap(this::extractValue);         
}

Stream<Map.Entry<String, String>> extractValue(Map.Entry<String, Object> entry) {
   if (entry.getValue() instanceof String) {
      return Stream.of(new AbstractMap.SimpleEntry(entry.getKey(), (String) entry.getValue()));
   } else if (entry.getValue() instanceof Map) {
      return flatten((Map<String, Object>) entry.getValue());
   }
}