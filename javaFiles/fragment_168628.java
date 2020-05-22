package testing.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Method {

    public WebDriver driver;
    WebElement _clickForSearch;
    public Method(WebDriver driver) {
        this.driver = driver;
    }
    public Method clickByXpath(String xpathValues) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        _clickForSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValues)));
        _clickForSearch.click();    
        return this;
    }


}