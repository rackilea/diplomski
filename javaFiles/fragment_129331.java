WebElement city = driver.findElement(By.xpath("//*[@id='StCityName_txtSpeedName']"));

    city.click();

    city.sendKeys("chennai");

   //wait for the iframe to load and then switch to it

    new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("SpeedTyperFrameID")));

    Thread,sleep(3000);//added just to show u the effect remove it      
    WebElement byValue = driver.findElement(By.id("SelectList"));

    //using select class to select the element by its text      
    Select select = new Select(byValue);

    select.selectByVisibleText("Chennai");

    //switch back to default content inorder to access other elements outside the iframe

    driver.switchTo().defaultContent();