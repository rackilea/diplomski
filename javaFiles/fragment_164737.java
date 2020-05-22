public class Foo {
    class Bar extends Foo {

    }

    class Fooey extends Bar {
        Fooey() {
            Foo.this.super();
        }
    }
}