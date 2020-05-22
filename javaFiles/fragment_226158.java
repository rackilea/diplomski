public class Foo {
    private String bar;
    private SomeClass bar2;

    public Foo() {
        this.bar = "";
        this.bar2 = new SomeClass();
        // other stuff...
    }

    public Foo(String bar, SomeClass bar2) {
        this.bar = "";
        this.bar2 = new SomeClass();
        this.bar = bar;
        this.bar2 = bar2;
        // other stuff...
    }
}