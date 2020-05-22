public void add(String key, String value) {
  List<String> values = map.get(key);
  if (values == null) {
    values = new ArrayList<String>();
  }
  values.add(value);
  map.put(key, values);
}