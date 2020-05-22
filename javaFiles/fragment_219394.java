public static void selectDate(){
        WebDriverWait wait=new WebDriverWait(driver, 50);
//      WebElement we=driver.findElement(By.xpath("//td[contains(@class, 'ui-datepicker') and @data-handler='selectDay']/a[contains(.,'10')]"));
        Actions builder=new Actions(driver);
        driver.findElement(By.id("departDate")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(@class, ' ui-datepicker')]/child::a[contains(@class,'ui-state')][contains(text(), '10')]")));
        builder.moveToElement(driver.findElement(By.xpath("//td[contains(@class, ' ui-datepicker')]/child::a[contains(@class,'ui-state')][contains(text(), '10')]"))).click().perform();
        boolean result = false;
        int attempts = 0;
        while(attempts < 10) {
            try {
                driver.findElement(By.xpath("//td[contains(@class, ' ui-datepicker')]/child::a[contains(@class,'ui-state')][contains(text(), '10')]")).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }