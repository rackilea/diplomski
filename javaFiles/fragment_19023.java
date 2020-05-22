String baseWindowHdl = driver.getWindowHandle();
driver.findElement(By.xpath("//xpath/to/button/id")).click();
//Go to New Window
for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle);
    }
enter your code here for new window

// Close pop-up
    driver.close();

    // Switch back to base window
    driver.switchTo().window(baseWindowHdl);