public class ClassInTest {

    private Medicine med;

    @Before
    public void setUp() {
        med= new Medicine("Medicine1", 110011, 100, 60);
    }

    @Test
    public void testSetName() {
        med.setName("ChangeMedicine");
        assertEquals("ChangeMedicine",med.getName());
    }
}