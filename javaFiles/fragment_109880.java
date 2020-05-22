// define reusable Bys
By usernameInput = By.xpath("//input");
By passwordInput = By.xpath("//div[2]/div/div/input");
By submitButton = By.xpath("//a[contains(@href, '#')]");

// wait for all elements to be visible
wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
// clear username field and type username
driver.findElement(usernameInput).clear();
driver.findElement(usernameInput).sendKeys("root");
// clear password field and type password
driver.findElement(passwordInput).clear();
driver.findElement(passwordInput).sendKeys("pass");
// submit the form
driver.findElement(submitButton).click();