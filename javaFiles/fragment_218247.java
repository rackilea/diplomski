import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

public class WaitAndExecute {

public static void main(String[] args) throws InterruptedException {
     int countdown = 1;
        while (countdown < 10){
            System.out.println(countdown);
            JavascriptExecutor js = (JavascriptExecutor) driver;  // pass your webdriver reference variable 
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ++countdown;
            TimeUnit.SECONDS.sleep(10);
        }

}