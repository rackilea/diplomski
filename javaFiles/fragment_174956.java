WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
element.sendKeys("yourPassword");

//Now click on sign in button 
driver.findElement(By.id("signIn")).click();//next page