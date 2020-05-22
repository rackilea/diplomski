public class run {
    public static void main(String[] argv) {
        System.loadLibrary("test");
        test.make_functor().call(1,2.5);
    }
}