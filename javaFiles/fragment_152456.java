Foo foo = new Foo(a);

// later in the same file...
class Foo implements Bar {
    int a;
    Foo(int a) {
        this.a = a;
    }

    // Bar's method
    void xyz() {
        if (this.a == ... ) ...
    }
}