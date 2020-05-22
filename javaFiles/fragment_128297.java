abstract class C<K, T> {
    Base<K> a;
    Base<T> b;
    K getA() {
        return a.get();
    }

    T getB() {
        return b.get();
    }
}