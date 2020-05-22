private final Foo foo;
public Bar(Foo foo) {
    this.foo = foo;
}
...
public class Foo {
    Bar baz = new Bar(this);
    ...
}