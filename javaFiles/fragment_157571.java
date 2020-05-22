class ClassMap {
    private Map<Class<?>, InterA<?>> map = new HashMap<>();
    public <T> void put(Class<T> key, InterA<T> value) {
        map.put(key, value);
    }
    //we suppress unchecked cast warning because for Class<T> key we can put only InterA<T> value
    @SuppressWarnings("unchecked")
    public <T> InterA<T> get(Class<T> key) {
        return (InterA<T>) map.get(key);
    }
}