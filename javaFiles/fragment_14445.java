public class Foo {
    private Bar bar;

    public Foo(Bar bar) {
        this.bar = bar;
    }

    // immutable property - can only be read once this object is instantiated
    public Bar getBar() {
        return this.bar;
    }
}

public class Bar {
    private int x;

    public Bar(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

// some other java class
Bar bar = new Bar(10);
Foo foo = new Foo(bar);
bar.setX(5);