driver.get("https://twitter.com/login/");
 getVisibleElement(driver, "session[username_or_email]").sendKeys("viavisibleName");
 getVisibleElement(driver, "session[password]").sendKeys("viavisibleName");

public static WebElement getVisibleElement(WebDriver driver, String name) {
    List<WebElement> elements = driver.findElements(By.name(name));
    for (WebElement element : elements) {
        if (element.isDisplayed()) {
            return element;
        }
    }
    return null;
}