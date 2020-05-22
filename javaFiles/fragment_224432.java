interface Equatable<T> {
    public boolean isEqual(T instance);
}

class C implements Equatable<C> {
    boolean isEqual(C instance);
}