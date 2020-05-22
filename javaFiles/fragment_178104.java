@SuppressWarnings("rawtypes")
public Class getMessageClass() {
            int index =0; //In the case, you only have a generic type, so index is 0 to get the first one.
    Type genType = getClass().getGenericSuperclass();
    if (!(genType instanceof ParameterizedType)) {
        return Object.class;
    }
    Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
    if (index >= params.length || index < 0) {
        throw new RuntimeException("Index outof bounds");
    }
    if (!(params[index] instanceof Class)) {
        return Object.class;
    }
    return (Class) params[index];
}