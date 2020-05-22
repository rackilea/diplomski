Foo<T> {
    private T bar;
    public T get() { return bar; }

    public Foo(T bar) {
        this.bar = bar;
    }
}

class Bar {
    public void func() {}
}
...
Foo<Bar> foo = new Foo(new Bar());