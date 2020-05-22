public void resetFoos(Iterable<Foo<?>> foos) {
    for (Foo<?> foo : foos) {
        resetFoo(foo);
    }
}

private <T> void resetFoo(Foo<T> foo) {
    foo.setValue(foo.getValue());
}