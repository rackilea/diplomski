WebDriverWait wait = new WebDriverWait(driver,10);

//First click on dropdown down to open options
wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.dropdown > a.dropdown-toggle"))).click();

//Now select opened option
wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.dropdown-menu > li > a[href*='Billing']"))).click();