String alertText = "";
WebDriverWait wait = new WebDriverWait(driver, 5);
// This will wait for a maximum of 5 seconds, everytime wait is used

driver.findElement(By.xpath("//button[text() = \"Edit\"]")).click();//causes page to alert() something

wait.until(ExpectedConditions.alertIsPresent());
// Before you try to switch to the so given alert, he needs to be present.

Alert alert = driver.switchTo().alert();
alertText = alert.getText();
alert.accept();

return alertText;