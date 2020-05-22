public  void login(){

        SeleniumUtils.setTextFieldValue("input#username", "userName");
        SeleniumUtils.setTextFieldValue("input#password", "password");

        SeleniumUtils.clickOnElement("div#btnLogin");

    }

public static void setTextFieldValue(String cssSelector, String value) {
        WebDriver driver = new FirefoxDriver();
        WebElement field =driver.findElement(By.cssSelector(cssSelector));
        field.sendKeys(value);
    }


public  void clickOnElement(String divClass) {
        WebDriver driver = new FirefoxDriver();
        WebElement element = driver.findElement(By.cssSelector(divClass));
        element.click();
    }