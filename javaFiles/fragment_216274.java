public class YourActivity extends Activity {
    // Load Native Libary
    static {
        System.loadLibrary("your_lib_name");
    }

    public native void someFunction();
}