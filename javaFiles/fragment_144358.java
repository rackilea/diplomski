import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Q45106505_REGEX 
{

    public static void main(String[] args) 
    {


        System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);     
        driver.manage().window().maximize();
        driver.get("http://unsplash.com/");
        driver.findElement(By.xpath("//button[@class='_2OLVr _21rCr']/*[name()='svg' and @class='_32SMR']")).click();;
        List<WebElement> elem_list = driver.findElements(By.xpath("//div[@id='app']//div[@id='gridSingle']/div[@class='y5w1y' and @data-test='photo-component']//a[contains(@href,'/?photo=')]"));
        List<String> title_list = new ArrayList<String>();
        List<String> href_list = new ArrayList<String>();
        for (WebElement we:elem_list)
        {
            String my_title = we.getAttribute("title");
            title_list.add(my_title);
            String my_href = we.getAttribute("href");
            href_list.add(my_href);
        }

        for(int i=0; i<title_list.size(); i++)
        {
            System.out.println(title_list.get(i)+" at : "+href_list.get(i));
        }


    }

}