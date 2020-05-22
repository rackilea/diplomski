import static org.junit.Assert.*;
import org.junit.Test;

public class JUnitTest {

    /** Have JUnit run this test() method. */
    @Test
    public void test() throws Exception {

        assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});

    }
}