WebElement we = this.driver.findElement(By.id("size-btn"));

JavascriptExecutor executor = (JavascriptExecutor) driver;
executor.executeScript("arguments[0].click();", we);

waitForElementPresent(By.xpath("//div[@id='size-btn' and contains(@class,'opened')]/span"));