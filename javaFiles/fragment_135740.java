public class Foo {

    private static Foo foo;

    private Foo() { }

    public static Foo getInstance() {
        if (foo == null) {
            foo = new Foo();
        }
        return foo;
    }
}