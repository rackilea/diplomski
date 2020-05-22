@RunWith(JUnit4.class)
public class TestEarlyReturn {
    @Test
    public void testEarly() {
        EarlyReturn.whatHappens(true);
    }

    @Test
    public void testNormal() {
        EarlyReturn.whatHappens(false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrow() {
        EarlyReturn.whatHappens(null);
    } 
}