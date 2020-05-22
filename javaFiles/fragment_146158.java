driver = new FirefoxDriver();
driver.get("http://www.stepintohealth.qa");

By byCss = By.cssSelector(".right1.navmenu a.register");
WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(byCss ));
myDynamicElement.click();