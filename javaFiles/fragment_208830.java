public class Bar {
    private final Foo foo;

    @Override protected void finalize() {
        // The finalizer in foo may already have executed...
        foo.foo();
    }
}