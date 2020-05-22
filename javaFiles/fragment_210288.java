import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;


        private static void takeScreenshot() throws IOException, InterruptedException {
            // TODO Auto-generated method stub

            System.setProperty("webdriver.chrome.driver", "chromedriver");              
            driver = new ChromeDriver();

            driver.get("https://www.google.com/");
            Thread.sleep(2);

            TakesScreenshot scrShot =((TakesScreenshot)driver);
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File("/home/XXXX/Desktop/test.png");
            FileUtils.copyFile(SrcFile, DestFile);      

        }