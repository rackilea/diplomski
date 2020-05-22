import org.junit.*;
import static org.junit.Assert.*;
import mockit.*;
import com.sun.jna.*;

public final class JNATest {
    public interface ConvInterface extends Library {}

    public static class ConvServiceImpl {
        final String libraryLocation = "whatever";
        ConvInterface convInterface;

        public void instantiateConvLibrary() {
            convInterface = Native.loadLibrary(libraryLocation, ConvInterface.class);
        }
    }

    @Test
    public void testLib(
        @Mocked Native mockNative, @Mocked ConvInterface mockConvInterface
    ) {
        ConvServiceImpl myLib = new ConvServiceImpl();
        myLib.instantiateConvLibrary();

        assertSame(mockConvInterface, myLib.convInterface);
    }
}