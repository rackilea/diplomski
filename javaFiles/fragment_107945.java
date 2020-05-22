WebDriverWait wait = new WebDriverWait(driver, 20);
JavascriptExecutor js = (JavascriptExecutor) driver;

driver.get("https://maps.b144.co.il/");

WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.business-in-area")));
String iconUrl = (String) js.executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('content');", icon);