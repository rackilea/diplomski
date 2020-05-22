public class Foo {
    public static Foo INSTANCE = new Foo(); // Prints null

    public static String s = "bar";

    public Foo() {
        System.out.println(s);
    }
}