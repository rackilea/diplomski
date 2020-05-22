WebElement frame = driver.findElement(By.cssSelector("#open_iframe"));
driver.switchTo().frame(frame);

driver.findElement(By.cssSelector("#inputTextArea>textarea")).sendKeys("..");

// if you need switch out of iframe
// driver.switchTo().defaultContent();