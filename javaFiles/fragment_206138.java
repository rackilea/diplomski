private class TypedMap {
    private Map<Class<?>, List<?>> map = new HashMap<>();

    public <T> void put(Class<T> key, List<T> value) {
        map.put(key, value);
    }

    @SupressWarnings("unchecked")
    public <T> List<T> get(Class<T> clazz) {
        return (List<T>) map.get(clazz);
    }
}