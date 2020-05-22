public class OuterClass {

    public static void main(String... args) {
        InnerClass.foo = 7;
        System.out.println(InnerClass.foo);
    }

    private static class InnerClass {
         private static int foo;
         private static int bar;
    }
}