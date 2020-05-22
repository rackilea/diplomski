class Foo<T> {
    // converting this Foo<T> to Foo<R>
    // Normally, helper() would take a parameter related to T
    public <U> Foo<U> helper() {
        return Foo.<U>baz();
    }

    // Making a Foo<R>, R is not related to T
    public static <R> Foo<R> baz() {
        return new Foo<R>();
    }
}