public class MyType<T> {
    public MyType(Class<T> cls) {
        this.cls = cls;
    }

    private Class<T> cls;

    T cast(Object o) {
        return cls.cast(o);
    }
}