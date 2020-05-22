class A {
    public setValue(Object o) {…}
}

class B<T> extends A {
    @Override
    public setValue(T o) {…};
}

A a = new B<String>(); // this is valid
a.setValue(new Integer(123)); // this line would compile, but make no sense at runtime