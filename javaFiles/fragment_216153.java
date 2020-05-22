public class ClassObjectMap {
    private Map<Class<?>, Object> map = new HashMap<>();

    public <T> void put(Class<T> clazz, T value) {
        assert clazz.isInstance(value);
        map.put(clazz, value);
    }

    public <T> T get(Class<T> clazz) {
        return clazz.cast(map.get(clazz));
    }
}