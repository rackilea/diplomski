WebElement gotIt = driver.findElement(By.xpath("//div[@class='actions style-scope tv-overlay-account-active']//div[text()='Got it']"));

//gotIt.click(); throws element not interactable

// you can also try Javascript click -- work around element not interactable issue
((JavascriptExecutor)driver).executeScript("arguments[0].click();", gotIt);