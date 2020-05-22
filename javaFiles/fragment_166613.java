public class NFLPlayerTest {

    // instance of the class-under-test
    private NFLPlayer instance;

    // set up method executed before each test case is run
    @Before
    public void setUp() {
        instance = new NFLPlayer(); 
    }

    @Test
    public void testCalculateQbRatingHappy() {
        // SETUP
        instance.setTouchdowns(2);
        instance.setPassingAttempts(44);
        instance.setPassingYards(285);
        instance.setInterceptions(1);
        instance.setCompletedPasses(35);

        // CALL
        double result = playerStats.calculateQbRating();  

        // VERIFY
        // assuming here the correct result is 42.41, I really don't know
        assertEquals(42.41, result);
    }

    @Test
    public void testCalculateQbRatingZeroPassingAttempts() {
        // SETUP
        // passingAttempts=0 is not handled gracefully by your logic (it causes an ArithmeticException )
        // you will probably want to fix this 
        instance.setPassingAttempts(0);

        // CALL
        double result = playerStats.calculateQbRating();  

        // VERIFY
        // assuming here that you will return 0 when passingAttempts=0
        assertEquals(0, result);
    }
}