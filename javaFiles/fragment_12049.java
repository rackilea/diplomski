Map<String, Object> treeMap = mapper.readValue(json, Map.class);

List<String> keys  = Lists.newArrayList();
List<String> result = findKeys(treeMap, keys);
System.out.println(result);

private List<String> findKeys(Map<String, Object> treeMap , List<String> keys) {
    treeMap.forEach((key, value) -> {
      if (value instanceof LinkedHashMap) {
        Map<String, Object> map = (LinkedHashMap) value;
        findKeys(map, keys);
      }
      keys.add(key);
    });

    return keys;
  }