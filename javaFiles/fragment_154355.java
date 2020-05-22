//If the Element is not visible then wait until that element is not visible
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("btn btn-warning")));

        //If the element is visible but not Clickable then wait until that element get Clickable.       
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("btn btn-warning")));

        //Then simply click the button
        driver.findElement(By.className("btn btn-warning")).click();