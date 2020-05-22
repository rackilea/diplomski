public class Test {
    public static void main(String... args) {
        TestClass t = new TestClass();
        // this is actually calling a synthetic accessor method
        t.hello = "x";
    }
    static class TestClass {
        private String hello;
    }
}