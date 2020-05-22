public class Test {
    public static void main(String[] args) {
        String[] x = { "hello" };
        // Copy the *reference*
        String[] y = x;
        System.out.println(y[0]); // Prints "hello"
        x[0] = "new value";
        System.out.println(y[0]); // Prints "new value"
    }
}