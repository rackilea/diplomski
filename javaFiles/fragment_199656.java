public static <T> void doSomething(final Class<T[]> arrayType) {

    @SuppressWarnings("unchecked")
    final Class<T> componentType = (Class<T>)arrayType.getComponentType();

    //etc.
}