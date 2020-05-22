public class Foo {
    static int fubar;
    public Foo() {
        ((Foo)null).fubar = 137;
    }
}