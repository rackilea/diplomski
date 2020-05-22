public class InitializerTest {
    {
        System.out.println("Initializer block");
    }

    private InitializerTest(Void v) {
        System.out.println("Constructor");
    }

    protected InitializerTest() {
        this(staticMethod());
    }

    private static Void staticMethod() {
        System.out.println("Static method");
        return null;
    }
}