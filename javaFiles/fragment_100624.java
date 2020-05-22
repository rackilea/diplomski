public class SafeTest {

    Safe safe1;
    Safe safe2;

    @Before
    public void setUp() {
        safe1 = new Safe();
        safe2 = new Safe();
        safe2.activate("Initial");
    }

    @Test
    public void testSetToActiveWrong() {
        System.out.println("Testing setting to active with wrong password: ");
        assertEquals("safe1.activate(\"wrongwrong\")", true, safe1.activate("wrongwrong"));
        assertEquals("safe2.activate(\"wrongwrong\")", false, safe2.activate("wrongwrong"));
    }

    // rest of class...