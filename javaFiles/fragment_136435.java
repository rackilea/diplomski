public class Example {
    public static Object a;
    private static Object b;

    public static void main(String... args) {
        Object foo = new Object();
        a = foo;
        b = foo;
        // Now our Object is referred to by the public field a, the private
        // field b, and the local variable foo (which is not considered either
        // private or public).
    }
}