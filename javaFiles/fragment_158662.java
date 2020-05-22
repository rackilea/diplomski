WebElement iframe = driver.findElement(By.tagName("iframe"));
driver.switchTo().frame(iframe);           //Move inside to the frame.
WebElement body = driver.findElement(By.tagName("body"));
body.click();
driver.findElement(By.linkText("sign in")).click();
driver.switchTo().defaultContent();       //Move outside to the frame.