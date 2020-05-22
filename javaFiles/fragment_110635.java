Map<Class<?>, Map<String, ?>> maps = new HashMap<>();

public <T> T getInstance(String key, Class<T> type, Supplier<T> objectSupplier) {

    Map<String, T> map;
    if (maps.containsKey(type)) {
        map = (Map<String, T>) maps.get(type);
    } else {
        map = new HashMap<>();
        maps.put(type, map);
    }

    if (map.containsKey(key)) {
        return map.get(key);
    }

    T result = objectSupplier.get();
    map.put(key, result);
    return result;
}