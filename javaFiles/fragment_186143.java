public class MyClass<T> {
    // ...

    public static <T> MyClass<T> forClass(Class<T> c) {
        return new MyClass<T>();
    }

    public static <T> MyClass<T> forObject(T object) {
        return new MyClass<T>();
    }
}