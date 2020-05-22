import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTestClass {

    @Test
    public void testTabnameSetting() {
        //Simulating toggling between multiple flows.
        String tabName = "LoginCredentials";
        Reporter.getCurrentTestResult().getTestContext().setAttribute("sheetName", tabName);
    }

    @Test(dependsOnMethods = "testTabnameSetting", dataProvider = "getData")
    public void loginSuccess(String username, String pass) {
        //test method logic goes here. .....


    }

    @DataProvider
    public Object[][] getData(ITestContext context) {
        String sheetNameToParse = context.getAttribute("sheetName").toString();

        String excelPath = "src/main/java/apps/teamo/testdata/Book 1.xlsx";
        return testData(excelPath, sheetNameToParse);
    }
}