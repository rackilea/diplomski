WebDriverWait wait = new WebDriverWait(driver, 10);

//Find frame or iframe and switch
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("your frame id or name"));

//Now find the element 
WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-test='testing-job-subject']")));

//Once all your stuff done with this frame need to switch back to default
driver.switchTo().defaultContent();