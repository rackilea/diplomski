public class TestCase {
    public static TypeA methodA() {
        return methodB();
    }

    public static <T extends TypeB> T methodB() {
        return (T) null;
    }
}