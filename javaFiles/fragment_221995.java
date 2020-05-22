WebElement element1 = driver.findElement(By.xpath("//a[@class='k-grid-filter']"));
JavascriptExecutor executor1 = (JavascriptExecutor) oBrowser;
executor1.executeScript("arguments[0].click();", element1);

WebElement element = driver.findElement(By.xpath(".//*[@id='adminGrid']/div[1]/table/thead/tr/th[1]/a‌​[1]/span"));
JavascriptExecutor executor = (JavascriptExecutor) oBrowser;
executor.executeScript("arguments[0].click();", element);