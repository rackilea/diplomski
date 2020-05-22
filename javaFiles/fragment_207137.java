WebElement iframe = webDriver.findElement(By.id("infoView_home"));
webDriver.switchTo().frame(iframe);

webDriver.findElement(By.id("usernameTextEdit")).clear();
webDriver.findElement(By.id("usernameTextEdit")).sendKeys("SomeUserName");

webDriver.findElement(By.id("passwordTextEdit")).clear();
webDriver.findElement(By.id("passwordTextEdit")).sendKeys("Some Password");