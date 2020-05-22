class ListClass<T> {
    private ObjectFactory<T> factory;

    ListClass<T>(Class<T> type) {
        factory = new ObjectFactory(type);
    }

    static <T> ListClass<T> of(Class<T> type) {
        return new ListClass<T>(type);
    }
}

ListClass<GameObject> list =
    ListClass.of(GameObject.class);