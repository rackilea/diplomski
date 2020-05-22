public class Test {

    private static int k = 0;

    public static void main(String[] args) throws Exception {
        foo(k++);
    }

    private static void foo(int x) {
        System.out.println("Value of parameter: " + x);
        System.out.println("Value of k: " + k);
    }
}