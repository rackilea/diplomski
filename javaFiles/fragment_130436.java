public class Test {

    public static void main(String[] args) throws Exception {
        System.loadLibrary("test");
        new Test().nativeMethod(0, 1);
    }

    private native Object nativeMethod(long a, int b);
}