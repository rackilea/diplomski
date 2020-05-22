// WebDriver instance for explicit wait by default on until condition
WebDriverWait wait = new WebDriverWait(driver, 5000);
// waits until elements gets ready 
WebElement we = wait
              .until(ExpectedConditions.elementToBeClickable(By
                            .xpath("//*[@id=\"searchSubmit\"]")));

//  once elements is ready it will clicked
driver.findElement((By) we).click();

driver.findElement(By.xpath("//*[@id=\"searchSubmit\"]")).click();