WebElement fileInput = driver.findElement(By.cssSelector("input[ng-model=files]"));

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].style.visibility = 'visible'; arguments[0].style.overflow = 'visible'; arguments[0].style.height = '1px'; arguments[0].style.width = '1px'; arguments[0].style.opacity = 1", fileInput);

fileInput.sendKeys("/absolute/path/to/a/file");