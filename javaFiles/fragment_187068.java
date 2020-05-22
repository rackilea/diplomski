Map<String, String> map = new HashMap<>(); // Concatenated string values
List<String> get(String key) {
    return Arrays.asList(map.getOrDefault(key, "").split("\f"));
}

Map<String, String[]> map = new HashMap<>();
private static final String[] EMPTY = new String[0];
List<String> get(String key) {
    return Arrays.asList(map.getOrDefault(key, EMPTY));
}

Map<String, List<String>> map = new HashMap<>(); // LinkedList
List<String> get(String key) {
    return map.get(key);
}