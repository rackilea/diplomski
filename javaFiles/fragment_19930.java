@When("^I hover over menu item \"(.*)\"$")
public void I_hover_over_menu_item(String menuItem)
{
    WebDriver driver = getWebDriver();
    By by = By.xpath("//*[@pageid='" + menuItem + "']");
    Actions action = new Actions(driver);
    WebElement elem = driver.findElement(by);
    action.moveToElement(elem);
    action.perform();
    this.sleep(2);
}

public void sleep(int seconds) 
{
    try {
        Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {

    }
}