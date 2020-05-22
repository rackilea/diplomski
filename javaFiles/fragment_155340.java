public Class<?> getGenericType(Object obj) {
    Class<?> genericType = null;
    Type gnrcType = obj.getClass().getGenericSuperclass();
    if (gnrcType instanceof ParameterizedType) {
        ParameterizedType parameterizedType = (ParameterizedType) gnrcType;
        Type types[] = parameterizedType.getActualTypeArguments();

        if (types != null && types.length > 0) {
            Type type = types[0];
            if (type instanceof Class) {
                genericType = (Class<?>) type;
            }
        }
    }
    return genericType;
}