import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public void tripleClick() {
    Actions action = new Actions(driver);
    WebElement cursor = driver.findElement(By.xpath("//div[contains(@id,'rCursor')]"));
    int count = 3;

    while(count>0){
        action.click(cursor).perform();
        count -= 1;
    }
}