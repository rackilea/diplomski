public class Test {
    private static <T> void staticMethod() {}
    private <T> void method() {}
    public Test() {
        method();                // Works!
        <Integer>method();       // Doesn't work!
        this.<Integer>method();  // Works again!
    }

    public static void main(String[] args) {
        staticMethod();                // Works!
        <Integer>staticMethod();      // Doesn't work
        Test.<Integer>staticMethod(); // Works again!
    }
}