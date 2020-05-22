//After modal window is opened
WebElement txtBox = driver.findElement(By.css("input[type='text']")); //textBoxPresent in popup 
txtBox.click(); //now the background will scroll to top.
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView(true)",txtBox); // this will scroll the textbox to the view port hence available for selenium to interact
txtBox.sendKeys("someText");