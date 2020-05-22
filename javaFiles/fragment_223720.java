driver.switchTo.frame("zohoiam"); // switch by iframe ID

WebElement emailfield = driver.findElement(By.id("lid"));
// some more code

driver.switchTo().defaultContent(); // switch out of the iframe