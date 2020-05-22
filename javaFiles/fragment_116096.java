driver.switchTo().frame(0);
 // your steps
 // now going to find button

 WebElement el = driver.findElement(By.xpath("//span[contains( text(),'View Report')]/parent::button"));
 JavascriptExecutor executor = (JavascriptExecutor)driver;
 executor.executeScript("arguments[0].click()", el);