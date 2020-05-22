// define locators for use later
// this also makes maintenance easier because locators are in one place, see Page Object Model
By alertLocator = By.cssSelector("div.noty_body");
By createLocator = By.cssSelector("div.action_menu_trigger");

// do something that triggers the alert

// wait for the alert to appear and then disappear
WebDriverWait shortWait = new WebDriverWait(driver, 3);
WebDriverWait longWait = new WebDriverWait(driver, 30);
shortWait.until(ExpectedConditions.visibilityOfElementLocated(alertLocator));
longWait.until(ExpectedConditions.invisibilityOfElementLocated(alertLocator));

// now we wait for the desired element to be clickable and click it
shortWait.until(ExpectedConditions.elementToBeClickable(createLocator)).click();