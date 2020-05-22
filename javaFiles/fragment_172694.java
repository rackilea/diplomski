import com.sun.jna.Library;
import com.sun.jna.Native;

public class LibFooDemo {

    public interface FooLibrary extends Library {
        FooLibrary INSTANCE = (FooLibrary)
                Native.loadLibrary("foo", FooLibrary.class);
        void foo(String[] format);
    }

    public static void main(String[] args) {
        String[] vals = {"foo", "bar", "foobar"};
        FooLibrary.INSTANCE.foo(vals);
    }
}