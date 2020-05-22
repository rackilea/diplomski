class Bar {
    static final long bar;

    static {
        System.out.println("Assigning bar");
        bar = Foo.foo;
    }
}
class Foo extends Bar {
    static final long foo;

    static {
        System.out.println("Assigning foo");
        foo = 1;
    }
}

public class Test {
    public static void main(String[] args) {
        new Foo();
        System.out.println(Bar.bar);
    }
}