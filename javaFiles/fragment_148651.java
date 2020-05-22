static <T> Class<T> getActualTypeArgument(Class<?> clazz, int i) {
    Type superclazz = getClass().getGenericSuperclass();
    ParameterizedType paramType = (ParameterizedType) superclazz;

    @SuppressWarnings("unchecked")
    final Class<T> actual =
        (Class<T>) paramType.getActualTypeArguments()[i];
    return actual;
}