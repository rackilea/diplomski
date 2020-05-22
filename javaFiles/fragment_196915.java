import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestFile {

    WebDriver driver = new FirefoxDriver();

    @Test
    public void Testone() {

        driver.get("http://www.google.com/");
        assert false;

    }

    @AfterMethod(alwaysRun = true)
    public void catchExceptions(ITestResult result) {
        System.out.println("result" + result);
        String methodName = result.getName();
        System.out.println(methodName);

        if (!result.isSuccess()) {

            try {

                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("C:\\screenshot2.png"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }
}