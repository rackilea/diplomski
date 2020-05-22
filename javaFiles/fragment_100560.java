WebElement element = driver.findElement(By.xpath("String1"));
element.convertStringToXpath("String2");

// Method written in some other class
public WebElement convertStringToXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }