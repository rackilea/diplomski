import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws Exception {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
        screenShot(driver);
        screenShot(driver);
        screenShot(driver);
    }

    public static void screenShot(FirefoxDriver driver) throws IOException, InterruptedException {
        File scr=(driver).getScreenshotAs(OutputType.FILE);
        File dest= new File("filPath/screenshot_"+timestamp()+".png");
        FileUtils.copyFile(scr, dest);
        Thread.sleep(3000);
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }