interface Generic<T> {
    void foo(T t);
}

class Impl implements Generic<MyType> {
    @Override
    public void foo(MyType t) { }
}