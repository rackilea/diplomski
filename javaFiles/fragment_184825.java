import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTestClass {
    /**
     * This method is simulating the master test method which would interact with
     * the web app and bring the application to a state wherein the next test method
     * should take over and interact.
     */
    @Test
    public void testLogin() {
        //Simulating toggling between multiple flows.
        int whichFlow = Integer.parseInt(System.getProperty("flow", "1"));
        Reporter.getCurrentTestResult().getTestContext().setAttribute("flow", whichFlow);
    }

    /**
     * This method is intentionally dependent on "testLogin" because its "testLogin" that will
     * first interact with the web application and bring the application to the place from where
     * further interaction is required, but which will vary based on some "x" criteria
     * The "x" criteria is now available as an attribute in the current &lt;test&gt; tag's
     * context.
     */
    @Test(dependsOnMethods = "testLogin", dataProvider = "getData")
    public void testSomethingElse(int a, String b) {
        //Real test method logic goes here.
        System.out.println(a + ":" + b);

    }

    @DataProvider
    public Object[][] getData(ITestContext context) {
        int whichFlow = Integer.parseInt(context.getAttribute("flow").toString());
        switch (whichFlow) {
            case 1:
                return new Object[][]{
                        {1, "Login"},
                        {2, "Signup"}
                };
            case 2:
                return new Object[][]{
                        {100, "Fees"},
                        {200, "Charges"}
                };

            case 3:
            default:
                return new Object[][]{
                        {900, "Logout"},
                        {1000, "Random"}
                };

        }
    }
}