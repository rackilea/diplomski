package Duplicates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Find_Duplicates_In_List {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        WebElement dropDown = driver.findElement(By.id("month"));
        Select select = new Select(dropDown);
        List<WebElement> options = select.getOptions();
        ArrayList<String> months = new  ArrayList<>();
        for(WebElement we : options)
        months.add(we.getText());
        System.out.println("Current list of months: " +months);
        months.add("Month");
        months.add("Feb");
        months.add("Dec");
        System.out.println("Duplicated months: " +findDuplicates(months));
    }

    public static Set<String> findDuplicates(List<String> listContainingDuplicates)
    { 
      final Set<String> setToReturn = new HashSet<>();
      final Set<String> set1 = new HashSet<>();
      for (String myString : listContainingDuplicates)
      {
       if (!set1.add(myString))
        setToReturn.add(myString);
      }
      System.out.println("Unique months: " +set1);
      return setToReturn;
    }
}