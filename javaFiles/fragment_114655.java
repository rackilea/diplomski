package tst;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public class Ada_Lib {

    public interface My_Ada_Lib extends Library {

        My_Ada_Lib instance = (My_Ada_Lib) Native.loadLibrary("libadalib", My_Ada_Lib.class);
        My_Ada_Lib synchronizedInstance = (My_Ada_Lib) Native.synchronizedLibrary(instance);

    void Renamed_myService (
                        Pointer inBuffer,
                        int anInteger,
                        byte[] outBuffer,
                        int outBufferSize,
                        IntByReference usedBufferSize
                       );
    }
}