@RunWith(Parameterized.class)
public class LocalTemperatureTest {

    private final double testValue;
    private final String expectedResult;
    private final LocalTemperature testSubject;


    public LocalTemperatureTest(Locale locale, double testValue, String expected) {
        ResourceBundle bundle = ResourceBundle.getBundle("MyResources", locale);

        this.testSubject = new LocalTemperature(bundle);
        this.testValue = testValue;
        this.expectedResult = expected;
    }

    @Test
    public void test() {
        TestCase.assertEquals("Conversion error", expectedResult, testSubject.format(testValue));
    }

    @Parameters(name="{index}: locale={0}  kelvin={1}  expected={2}")
    public static Iterable<Object[]> getTestParameters() {
        Locale norwegian = new Locale("nr");

        Object[][] parameters = {
                {Locale.GERMAN, 0, "-273,15°C"},
                {Locale.GERMAN, 273.15, "0°C"},
                {Locale.GERMAN, 287.15, "14°C"},
                {Locale.GERMAN, 287.35, "14,2°C"},
                {Locale.GERMAN, 287.38, "14,23°C"},
                {Locale.GERMAN, 287.384, "14,23°C"},
                {Locale.GERMAN, 287.385, "14,24°C"},
                {norwegian, 287.15, "14 °C"},
                {Locale.US, 300.0, "80.33 °F"}
        };
        return Arrays.asList(parameters);
    }
}