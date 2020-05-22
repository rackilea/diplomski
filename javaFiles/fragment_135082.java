public Generic() {
    Type genericType = getClass().getGenericSuperclass();
    if (genericType instanceof ParameterizedType) {
        entityClass = ((Class) ((Class) ((ParameterizedType) genericType).getActualTypeArguments()[0]));
    }
    else {
        entityClass = getClass().getSuperclass();
    }
}