public class A {

    public native void a(android.graphics.Bitmap.Config b);
    public native void a(android.graphics.Bitmap.Config b, int c);
    static {
        System.loadLibrary("hello-libs");
        a(null);
    }
}