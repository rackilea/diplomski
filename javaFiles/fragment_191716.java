// This way allows you to select an iframe using 'By' and access it.
driver.switchTo().frame(driver.findElement(By.id("frameId")));

// Now you can only handle the iframe elements, like your request
driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("John");

// After execute all that you need inside the iframe, 
// returns you to default html, outside the iframe.
driver.switchTo().defaultContent();