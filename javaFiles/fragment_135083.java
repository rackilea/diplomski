public Generic() {
    Class cClass = getClass();
    do {
        Type genericType = cClass.getGenericSuperclass();

        if (genericType instanceof ParameterizedType) {
            entityClass = ((Class) ((Class) ((ParameterizedType) genericType).getActualTypeArguments()[0]));
        }
        else {
            cClass = cClass.getSuperclass();
        }
    } while (entityClass == null);
}