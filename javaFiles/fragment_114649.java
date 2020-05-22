class Foo {
    static {
        if (true) {
            throw new RuntimeException();
        }
    }

    static void foo() {
    }
}

public class Test {

    public static void main(String[] args) {
        try {
            Foo.foo();
        } catch (Throwable t) {
            System.out.println("First exception: " + t);
        }
        try {
            Foo.foo();
        } catch (Throwable t) {
            System.out.println("Second exception: " + t);
        }
    }
}