public <T, R> IGetter<T, R> getGetter(Class<T> clazz, Field field) {
    Class<R> fieldType = null;
    try {
        fieldType = (Class<R>) field.getType();
    } catch(ClassCastException e) {
        error("Attempted to create a mistyped getter for the field " + field + "!");
    }
    return getGetter(clazz, field.getName(), fieldType);
}