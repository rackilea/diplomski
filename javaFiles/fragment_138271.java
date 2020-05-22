public <T> void foo(A<T> bar) {
    // ...
}

private interface A<T> {
    Object work(final Fizz fizz, final T t);
}

private interface B extends A<Void> {

    default Object work(final Fizz fizz) {
        return work(fizz, null);
    }

    Object work(final Fizz fizz, final Void ignoreMe);
}