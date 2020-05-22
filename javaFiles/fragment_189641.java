@SuppressWarnings({ "unchecked", "rawtypes" })
public <T> Class<? extends StringConverter<T>> getConverter(Class<T> forType) {
    if (forType.equals(int.class) || forType.equals(Integer.class)) {
        return (Class) IntegerConverter.class;
    } else if (forType.isEnum()) {
        return (Class) EnumConverter.class;
    } else {
        return null;
    }
}