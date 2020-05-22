WebElement selectMenu = driver.findElement(By.xpath("//md-select[normalize-space(@aria-label='Phone to call with')]"));
WebElement option = driver.findElement(By.xpath("//md-select[normalize-space(@aria-label='Phone to call with')]//md-option[normalize-space(.)='Hangouts']"));

//1. first click to open dropdown, second click on option
selectMenu.click();
new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(option)).click();

//2. select using javascript
((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);