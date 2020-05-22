WebDriverWait wait = new WebDriverWait(driver, 30);

// first, wait for the loadmask to be visible to avoid race condition
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='loading']")));

// now, wait for load mask to disappear -- loading complete after this
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='loading']")));