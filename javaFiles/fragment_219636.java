public class Foo {
    private static Foo INSTANCE = new Foo(); // Prints null
    private static String s = "foo";

    public Foo() {
        System.out.println(s);
    }
}