driver.get("https://www.tripadvisor.in/");
    WebDriverWait wait = new WebDriverWait(driver, 120);
    WebElement ele1 =  
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Where to?']")));
    ele1.click();

    WebElement ele2= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='Where to?']")));
    ele2.sendKeys("club mahindra, india");

    WebElement ele3= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Search for ')]")));
    ele3.click();
    WebElement ele4= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Club Mahindra Madikeri, Coorg')]")));
    ele4.click();   //this click leads to a new tab 

    Set<String> winHandles = driver.getWindowHandles();  

    for(String str : winHandles) {
        driver.switchTo().window(str);
    }
    System.out.println(driver.getTitle());

    WebElement ele;
    int i=1;
    while(true) {
        try {
         ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Write a review']")));
         break;
        }catch(Exception e) {
            System.out.print(i++);
        }
    }
    System.out.println();
    Actions action = new Actions(driver);
    action.moveToElement(ele);
    ele.click();
    System.out.println("Clicked on the 'Write a review button'");