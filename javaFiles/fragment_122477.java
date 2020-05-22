driver.switchTo().frame("navFrame");
driver.switchTo().frame("contentFrame");

//Now find desire element 
new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("CCC_PH3_Sandbox_Keybridge"))).click();

//After doing all stuff inside iframe switch back to default content 
driver.switchTo().defaultContent();