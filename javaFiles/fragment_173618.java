import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RetryProvider {
    @Test(dataProvider = "datasource", retryAnalyzer = RetryAnalyzer.class)
    public void Test1(int code, String type, ITestContext context) {
        System.out.println("Test1(): " + code + " : " + type);
        Assert.fail(); //** enforce a retry **/
    }

    @DataProvider(name = "datasource")
    public Object[][] getData(ITestContext ctx) {
        Object[][] data = new Object[1][3];
        data[0][0] = 1;
        data[0][1] = "apple";
        data[0][2] = ctx;
        return data;
    }
}