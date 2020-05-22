ListMultimap<Integer, String> listMap = ArrayListMultimap.create();

public void addValue(Integer key, String value) {
    listMap.put(key, value);
}

public List<String> getValues(Integer key) {
    return listMap.get(key);
}

public Map<Integer, List<String>> asMap() {
    // See documentation for details
    return Multimaps.asMap(listMap);
}