public class SampleTestSuite extends WebDriverTestCase {
    @Test
    public void test1() {
        getDriver().get("/");
        List<QAFWebElement> eles = getDriver().findElements(locator);
        //List<QAFWebElement> eles = getDriver().findElements(By.name("q"));
    }
}