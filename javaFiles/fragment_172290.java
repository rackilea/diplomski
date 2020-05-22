String markerValue = "1.32";

        WebElement rainMarker = driver.findElement(By.xpath("//div[@id='mapDiv']/div/div/div/div[not(contains(@style,'display'))]"
                + "//a[@class='MapPushpinBase']/div[@class='rainMarker'][.='"+ markerValue +"']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(rainMarker).perform();

        new WebDriverWait(driver, 3, 100).until(ExpectedConditions.visibilityOf(rainMarker));

        driver.findElement(By.xpath("//div[@id='infoBox'][contains(@style,'visibility: visible')]/a")).click();