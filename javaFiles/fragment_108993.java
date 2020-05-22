import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.DayOfWeek;

public class TestNgPlayground implements IHookable {

    private static final DayOfWeek SOME_CONST = DayOfWeek.TUESDAY;

    @DataProvider
    public Object[][] getStuff() {
        return new Object[][]{
                {"param1", DayOfWeek.MONDAY},    // Skip this
                {"param2", DayOfWeek.TUESDAY},  // Run this
                {"param3", DayOfWeek.WEDNESDAY} // Skip this
        };
    }

    @Test(dataProvider = "getStuff")
    public void testt(String param1, DayOfWeek param2) {
        System.err.println("[" + param1 + ", " + param2 + "]");
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        Object[] parameters = callBack.getParameters();
        DayOfWeek dataProviderValue = (DayOfWeek) parameters[1];
        if (dataProviderValue != SOME_CONST) {
            callBack.runTestMethod(testResult);
        } else {
            testResult.setStatus(ITestResult.SKIP);
        }
    }
}