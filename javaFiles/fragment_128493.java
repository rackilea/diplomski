WebElement Reports = driver.findElement(By.xpath("--------//---As per your code"));
WebElement Asset Management = driver.findElement(By.xpath("--------//---As per your code"));
WebElement Terminated_Report_Pending = driver.findElement(By.xpath("--------//---As per your code"));
        Actions builder = new Actions(driver);
        builder.moveToElement(Reports).perform();
        Thread.sleep(3000);
        builder.moveToElement(Asset Management).perform();
        Terminated_Report_Pending.click();