WebElement scrollArea = driver.findElement(By.className("wrapper"));

// Scroll to div's most right:
((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);

// Or scroll the div by pixel number:
((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 250", scrollArea);