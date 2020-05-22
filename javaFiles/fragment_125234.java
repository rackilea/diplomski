@RunWith(Parametrized.class)
public class SumTest {
    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {{1, 2, 3}, {3, 4, 7}});
    }

    private int a, b, sum;
    public SumTest(int a, int b, int sum) {
        this.a = a;
        this.b = b;
        this.sum = sum;
    }

    @Test
    public void testSum() {
        Assert.assertEquals(a + b, sum);
    }
}