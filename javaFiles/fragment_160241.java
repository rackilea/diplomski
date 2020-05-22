public class MyClass<E> {
    private final Class<E> realType;
    public MyClass(Class<E> realType) {
        this.realType = realType;
    }
    public boolean Contains(Object o) {
        E e = realType.cast(o); // runtime cast - will throw ClassCastException.
        // Could also use realType.isInstance(o)
        // or realType.isAssignableFrom(o.getClass())
        ...
    }
}