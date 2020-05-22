public class Baz {
    public int x = 0;
}

public class Foo {
    private Baz thing;

    public Foo() { thing = new Baz(); }

    public Baz getThing() {
        return this.thing;
    }
}

public class Bar {
    public Bar() { ... }

    public Object makeNewThing() { ... }

    public void changeThing() {
        Foo foo = new Foo();
        Baz thing = foo.getThing();
        thing.x = 10;
        System.out.println(foo.thing); // this will print 10, not 0
    }
}