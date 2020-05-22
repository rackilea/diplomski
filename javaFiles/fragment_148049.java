public class Test {
    public static void main(String[] args) {
        testOperations(Float.MAX_VALUE);
        testOperations(Float.POSITIVE_INFINITY);
    }

    public static void testOperations(float input) {
        System.out.println("input: " + input);
        System.out.println("input / 100: " + input / 100);
        System.out.println("input * 100: " + input * 100);
        System.out.println("-input: " + (-input));
        System.out.println();
    }
}