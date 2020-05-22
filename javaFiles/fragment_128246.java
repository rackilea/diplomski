WebDriverWait wait = new WebDriverWait(driver, 100);
String optionToSelect = "OPT1";
//Selector is the trick here
By selectElementSelector = By.cssSelector("select[id*='TaskId']>option[value='" + optionToSelect + "']");

wait.until(ExpectedConditions.presenceOfElementLocated(selectElementSelector)).click();