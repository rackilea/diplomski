WebElement password = driver.findElement(By.name("ctl00$ctl00$MasterContent$MainContentPlaceHolder$ViewCredentials$TopicPanel1$credentialGrid$editnew_4$txtPassword$P$PB$CVS")); 

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].setAttribute('type', 'text');", password);

password.sendKeys("MyPassword");