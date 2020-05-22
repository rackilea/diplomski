import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RetryWithDataProvider {
    @DataProvider(name = "Dataprovider")
    public Object[][] dataprovider(ITestContext ctx) {

        return new Object[][]{{1, ctx}, {2, ctx}, {3, ctx}};
    }

    @Test(dataProvider = "Dataprovider", retryAnalyzer = Retry.class)
    public void test(int data, ITestContext itx) {
        System.out.println(data);
        System.out.println("Current Test name is : " + itx.getName());
        org.testng.Assert.assertEquals(data, 3);
    }

    public static class Retry implements IRetryAnalyzer {

        private static int retryCount = 0;
        private int maxRetryCount = 1;

        public boolean retry(ITestResult result) {
            if (retryCount < maxRetryCount) {
                System.out.println("Retrying test " + result.getName() + " with status "
                        + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
                retryCount++;
                return true;
            }
            retryCount = 0;
            return false;
        }

        String getResultStatusName(int status) {
            String resultName = null;
            if (status == 1)
                resultName = "SUCCESS";
            if (status == 2)
                resultName = "FAILURE";
            if (status == 3)
                resultName = "SKIP";
            return resultName;
        }
    }
}