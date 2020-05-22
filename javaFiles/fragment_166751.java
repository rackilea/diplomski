import com.sun.jna.win32.StdCallFunctionMapper;
import com.sun.jna.win32.StdCallLibrary;

public class Main
{
    public interface TestLibrary extends StdCallLibrary
    {
        void fn_Today(int a,int b);
    }

    public static void main(String[] args)
    {
        Map options = new HashMap() {
            { put(Library.OPTION_FUNCTION_MAPPER, new StdCallFunctionMapper()) }
        };
        TestLibrary INSTANCE = (TestLibrary) Native.loadLibrary("test", TestLibrary.class, options);

        // ...
    }
}