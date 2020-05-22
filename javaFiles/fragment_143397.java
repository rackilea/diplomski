public static <T> Collection<T> getTypeFilteredSubCollection(Collection<Object> objects, Class<T> clazz) {
    Collection<T> typeFilteredCollection = new ArrayList<T>();
    for(Object object : objects) {
        if(clazz.isInstance(object)) {
            typeFilteredCollection.add((T)object);
        }
    }
    return typeFilteredCollection;
}