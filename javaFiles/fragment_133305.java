//Just to make sure the previous tag is present
By byId = By.id("MFE_sequence_spa");
new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(byId));

WebElement myDynamicElement = (WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('#MFE_sequence_span>pre');");
System.out.println(myDynamicElement.getText());