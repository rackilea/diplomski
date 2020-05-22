public <T, R> IGetter<T, R> getGetter(Class<T> clazz, Class<R> fieldType, Field field) {
    if(fieldType != field.getType()) {
        error("Attempted to create a mistyped getter for the field " + field + "!");
    }
    return getGetter(clazz, field.getName(), fieldType);
}