class GenericMap extends HashMap<Class<?>, Object> {

    public <T> T putClassAndInstance(Class<T> c, T o){
        return c.cast(super.put(c, o));
    }

    public <T> T getInstance(Class<T> c) {
        return c.cast(super.get(c));
    }
}