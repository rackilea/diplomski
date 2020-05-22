public class Main {
    static class A {
        public String[] invocations = {"foo"};
    }

    static class B extends A {
        public String[] invocations = {"bar", "baz"};
    }

    public static void main(String... args) {
        B b = new B();
        System.out.println("((A)b).invocations=" + Arrays.toString(((A) b).invocations));
        System.out.println("b.invocations=" + Arrays.toString(b.invocations));
    }
}