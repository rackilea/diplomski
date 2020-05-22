import static org.junit.Assert.assertEquals;

public class TestCase {

   private final Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);


    @Test
    public void testGetCode() {
        assertEquals("Some error message", "CSC8001", csc8001.getCode()) ;
    }

}