public class TestClass implements ITest {

    protected String description;
    protected int firstNumber;
    protected int secondNumber;
    protected int sum;

    @Test
    public void testProvider() {
        /**
         * Minus or plus here to make it fail or pass.
         */
        assertEquals(this.sum, this.firstNumber - this.secondNumber);
    }

    @Factory(dataProvider = "summationProvider")
    public TestClass(String description,
                     int firstNumber, int secondNumber, int sum) {
        this.description = description;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.sum = sum;
    }

    @DataProvider(name = "summationProvider")
    public static Object[][] summationData() {
        Object[][] testData = {{"TestName1", 1, 2, 3}, {"TestName2", 2, 2, 4}};
        return testData;
    }

    @Override
    public String getTestName() {
        return this.description;
    }
}