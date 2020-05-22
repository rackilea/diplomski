class Favorites {
    private Map<Class<?>, Object> map = new HashMap<Class<?>, Object>();

    public <T> T get(Class<T> clazz) {
        return clazz.cast(map.get(clazz));
    }

    public <T> void put(Class<T> clazz, T favorite) {
        map.put(clazz, favorite);
    }
}