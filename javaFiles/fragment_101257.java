interface RetrievableBySearch<E extends RetrievableBySearch<E>> {
    E searchForEntity(String searchKey);

    static <E extends RetrievableBySearch<E>> E getEntityBySearch(Class<E> entityClass,
            String searchKey) {
        try {
            return entityClass.newInstance().searchForEntity(searchKey);
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException("Unable to instantiate entityClass", e);
        }
    }
}