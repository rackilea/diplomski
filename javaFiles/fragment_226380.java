subtitleInputBox.sendKeys("Test");

//Now wait until value has been set into element 
new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElementValue(subtitleInputBox, "Test"));

//Now get the element value
subtitleInputBox.getAttribute("value");