// is a functional interface
interface Foo {
    void bar();
}

// is a functional interface
@FunctionalInterface
interface Foo {
    void bar();
}

// is not a functional interface
interface Foo {
    void bar();
    void baz();
}

// does not compile
@FunctionalInterface
interface Foo {
    void bar();
    void baz();
}