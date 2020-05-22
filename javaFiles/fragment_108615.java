Map<String, Object> map = SomeObj.getMap();
String key = "someKey";
if (map.get(key) instanceof List<?>) {
    List<?> list = (List<?>) map.get(key);
    Set<String> set = new HashSet<>();
    // Cast and add each element individually
    for (Object o : list) {
        set.add((String) o);
    }
    // Or, using streams
    Set<String> set2 = list.stream().map(o -> (String) o).collect(Collectors.toSet());
}