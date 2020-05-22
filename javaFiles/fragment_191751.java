public class Immutable<T> {
    private final T _t;
    public void Immutable(T t) {
        _t = t;
    }
    public T get() { return _t; } //you may want to return a copy of _t if _t is mutable
}