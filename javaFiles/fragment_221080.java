import org.junit.Test;
import static org.mockito.Mockito.*;

public class VoidTest {

    private interface TestClass {
        boolean doStuff(String arg);
    }

    @Test
    public void doIt() {
        TestClass tc = mock(TestClass.class);

        tc.doStuff("[SOMETHING]");

        verify(tc).doStuff("[SOMETHING]"); // OK
        verify(tc).doStuff("[SOMETHING ELSE ]"); // BOOM!
    }
}