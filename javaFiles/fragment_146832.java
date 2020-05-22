driver.switchTo().defaultContent(); // optional, use only if driver is already in an iframe

WebElement editUserForm = driver.findElement(By.cssSelector("iframe[src*='editUserForm']"));
// there are other overloads (by frame name, index, id) and locators can be used here.
driver.switchTo().frame(editUserForm);

// make sure your locator here is correct
WebElement lastName = driver.findElement(By.id("userDetailsBean.lastName")); // I doubt this is correct
// from your screenshot, I'd suggest By.cssSelector("[id*='userDetailsBean.lastName'] input")
lastName.sendKeys("harper");