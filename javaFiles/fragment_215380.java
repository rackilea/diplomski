class HasExample<T> {
    Example<T> myExample = new Example<T>();

    HasExample(T value) {
        myExample.value = value;
    }
}