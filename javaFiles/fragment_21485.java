public class Test {
    public static void main(String[] args) {
        Object o = new Object();
        // No exception
        Test.<String>fakeCast(o);
        // Exception at the point of assignment:
        // the code is effectively String x = (String) ...;
        String x = Test.<String>fakeCast(o);
    }

    private static <T> T fakeCast(Object o) {
        return (T) o;
    }
}