browser.get(url);

WebDriverWait wait = new WebDriverWait(browser, 10);

//Now find the expand button first
WebElement expand = wait.until(ExpectedConditions.elementToBeClickable(By.id("plusminus_housing_type")));

//Now scroll down and reach to the button
((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", expand);
//Now click on expand button
expand.click();

//Now wait until apartment checkbox visible and then find 
WebElement apartment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("apartment_1")));
//Now click on apartment check box      
apartment.click();