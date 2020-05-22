WebElement selectBox = driver.findElements(By.xpath("//span[contains(.,'Select from list')]")).get(1);

public static void actionClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }