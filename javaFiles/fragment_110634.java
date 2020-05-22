Map<String, Object> map = new HashMap<>();

public <T> T getInstance(String key, Supplier<T> objectSupplier) {
    if (instanceAMap.containsKey(key)) {
        return (T) map.get(key);
    }

    T result = objectSupplier.get();
    map.put(key, result);
    return result;
}