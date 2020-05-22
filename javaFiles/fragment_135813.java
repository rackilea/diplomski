@RunWith(Parameterized.class)
static public class FibonacciTest {

    @Parameters( name = "{index}: fib({0})={1}" )
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 },
                { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
    }

    private final int fInput;
    private final int fExpected;

    public FibonacciTest(int input, int expected) {
        fInput= input;
        fExpected= expected;
    }

    @Test
    public void testFib() {
        assertEquals(fExpected, fib(fInput));
    }

    private int fib(int x) {
        // TODO: actually calculate Fibonacci numbers
        return 0;
    }
}