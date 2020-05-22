public class MyClass<T> implements MyInterface<T, T> {

    @Override
    public T foo(T in) {
        return in;
    }
}