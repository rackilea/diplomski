import com.relevantcodes.extentreports.*;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created by andrey.smirnov on 14.06.2016.
 */
public class ExtentListener implements IResultListener {

    private ExtentReports reporter =  new ExtentReports("build/SimpleReport.html", true, DisplayOrder.NEWEST_FIRST, NetworkMode.OFFLINE, Locale.ENGLISH);
    private ExtentTest testReporter;


    @Override
    public void onTestStart(ITestResult result) {
        testReporter = reporter.startTest(result.getMethod().getMethodName(), "Some description");
        testReporter.log(LogStatus.INFO, "Starting test " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testReporter.log(LogStatus.PASS, "Test PASSED");
        reporter.endTest(testReporter);
        reporter.flush();
    }

    @Override
    public void onFinish(ITestContext context) {
        reporter.close();
    }

   // Other interface methods
}