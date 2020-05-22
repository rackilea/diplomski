public static final <T, U> Map<U, List<T>> invertMap(Map<T, U> map) {
    HashMap<U, List<T>> invertedMap = new HashMap<>();

    for (T key : map.keySet()) {
        U newKey = map.get(key);

        invertedMap.computeIfAbsent(newKey, k -> new ArrayList<>());
        invertedMap.get(newKey).add(key);

    }

    return invertedMap;
}