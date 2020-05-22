public class Foo {
    // static method with synchronized modifer
    public static synchronized void foo1() {
        // ...
    }
    // equivalent synchronized statement
    public static void foo2() {
        synchronized (Foo.class) {
            // ...
        }
    }
}