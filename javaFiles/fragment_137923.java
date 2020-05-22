public void addValue(Integer key, String value) {
    List<String> values = listMap.get(key);
    if (values == null) {
        listMap.put(key, values = new ArrayList<>());
    }
    values.add(value);
}