// or any locator strategy that you find suitable 
        WebElement locOfOrder = driver.findElement(By.id("id of the order id"));
Actions act = new Actions(driver);
act.moveToElement(locOfOrder).doubleClick().build().perform();
// catch here is double click on the text will by default select the text 
// now apply copy command 

driver.findElement(By.id("")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
// now apply the command to paste
driver.findElement (By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).sendKeys(Keys.chord(Keys.CONTROL, "v"));