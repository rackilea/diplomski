for(Map.Entry<String, List<String>> entry : map.entrySet()) {
  String key = entry.getKey();
  for (String value : entry.getValue()) {
    ...
  }
}