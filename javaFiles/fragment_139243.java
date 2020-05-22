public class FirstPage {

    public WebDriver driver;
    public WebElement element;

    public FirstPage (WebDriver driver) {
        this.driver = driver;
        this.element = driver.findElement(By.id("hptl"));
    }

}