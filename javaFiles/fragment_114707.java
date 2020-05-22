public class Main {
    private static native int zero();

    private static int testNative() {
        return Main.zero();
    }

    private static int test() {
        return 0;
    }

    public static void main(String[] args) {
        testNative();
        test();
    }

    static {
         System.loadLibrary("foo");
    }
}