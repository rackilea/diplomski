public static HashMap<String, ?> merge(HashMap<String ,?> map1, HashMap<String, ?> map2) {
    HashMap<String, Object> merged = new HashMap<>();
    merged.putAll(map1);
    merged.putAll(map2);
    return merged;
}