public class TestClass implements ITest {

    protected static ThreadLocal<String> description
            = new ThreadLocal<>();
    protected ParametrizedInput input;

    @BeforeMethod
    public void setUp(Method method) {
        this.description.set(this.description.get() + " " + method.getName());
    }

    @AfterMethod
    public void tearDown(Method method) {
        this.description.set(this.description.get().substring(0,
                this.description.get().length() - method.getName().length()));
    }

    @Test
    public void testProvider() {
        assertEquals(this.input.getSum(),
                this.input.getFirstNumber() / this.input.getSecondNumber());
    }

    @Test
    public void anotherTestProvider() {
        assertEquals(this.input.getSum(),
                this.input.getFirstNumber() - this.input.getSecondNumber());
    }
    @Factory(dataProvider = "summationProvider")
    public TestClass(String descriptionString, ParametrizedInput input) {
        this.description.set(descriptionString);
        this.input = input;
    }

    @DataProvider(name = "summationProvider")
    public static Object[][] summationData() {
        Object[][] testData = {{"TestName1", new ParametrizedInput(1, 2, 3)},
                {"TestName2", new ParametrizedInput(2, 2, 4)}};
        return testData;
    }

    @Override
    public String getTestName() {
        return this.description.get();
    }
}