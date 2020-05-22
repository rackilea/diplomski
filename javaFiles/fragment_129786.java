public class MyClass<T> {
    private final Class<T> clazz;
    // ...

    MyClass(final @NonNull Class<T> clazz) {
        this.clazz = clazz;
    }

    public <T> List<T> fetchObjectsForHashCriteria(@NonNull final T hashObject) {
        instance.getObjectsForHashCriteria(clazz, hashObject);
    }
}