class SomeImplementor<T extends Foo & Bar> implements FooBar {
    private T fSomeField;

    public T getFooBar() {
        return fSomeField;
    }

}