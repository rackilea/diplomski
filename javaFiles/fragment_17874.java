import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AbcTest {
    @Test
    public void testAdd() {
        System.out.println("add");
        int a = 0;
        int b = 0;
        Abc instance = new Abc();
        int expResult = 0;
        int result = instance.add(a, b);
        assertEquals(expResult, result);
    }
}