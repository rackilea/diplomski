class SomeClass<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public SomeClass(Class<T> klass, int size) {
        array = (T[]) Array.newInstance(klass, size);
    }

}