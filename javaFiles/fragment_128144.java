WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement element = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.id("ctl62_txtSearchLastName"))
);

element.sendKeys("test");