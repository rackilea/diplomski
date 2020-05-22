public <T extends BaseClass> void addImpl(SomeImpl<T> loader, Class<T> aClass) {
    map.put(type, loader);
}

public <T extends BaseClass> SomeImpl<T> getImpl(Class<T> aClass) {
    return (SomeImpl<T>) map.get(type);
}