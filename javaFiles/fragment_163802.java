import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

public class ConsoleHandlerTest {

    private PrintStream originalSysOut;
    private ByteArrayOutputStream mockOut;

    @Before
    public void setSysOut() {
        originalSysOut = System.out;
        mockOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOut));
    }

    @After
    public void restoreSysOut() {
        System.setOut(originalSysOut);
    }

    @Test
    public void outputIsCorrect() {
        new ConsoleHandler().write("hello");
            assertEquals("message output", "hello".trim(), mockOut.toString().trim());
    }

}