WebElement extensionBox = driver.findElement(By.xpath(".//a[normalize-space()='Selected Task']"));

Actions actionsTwo = new Actions(driver);
JavascriptExecutor jseTwo = (JavascriptExecutor) driver;
actionsTwo.moveToElement(extensionBox).click();
jseTwo.executeScript("arguments[0].click()", extensionBox);