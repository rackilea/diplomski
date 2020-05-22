setupWebDriverChrome();
    //Thread.sleep(1000);
    final String cssSelectorFromAirport = "div.od-airportselector.airportselector_root input[tabindex='11']";
    WebElement element = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelectorFromAirport)));
    /*final By cssSelector = By.cssSelector(cssSelectorFromAirport);
    WebElement fromAirportElement = driver.findElement(cssSelector);
    System.out.println("-->> " + fromAirportElement.isDisplayed() + " " + fromAirportElement.isEnabled() + " " + fromAirportElement.isSelected());*/
    element.clear();
    element.sendKeys("MUC");