public class Example {
    private static String foo = "foo";

    private String bar;

    private Example() {
        this.bar = "bar";
    }

    static class Inner {
        static void check() {
            System.out.println(foo);
            System.out.println(new Example().bar);
        }
    }

    public static final void main(String[] args) {
        Inner.check();
    }
}