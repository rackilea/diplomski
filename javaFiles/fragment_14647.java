public class Test {
    private static final String value;
    static {
        System.out.println("Test static");
        value = "test value";
    }
    public static void main(String[] args) {
        System.out.println(value);
    }
}