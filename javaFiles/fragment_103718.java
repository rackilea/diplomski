driver.get("https://demo.stqatools.com/MouseHover.php");
    WebElement hoverButton = driver.findElement(By.cssSelector(".dropbtn"));
    WebElement linkOne = driver.findElement(By.cssSelector(".dropdown-content > a"));

    //Activate modal dialogue
    Actions action = new Actions(driver);
    action.moveToElement(hoverButton).perform();
    wait.until(ExpectedConditions.visibilityOf(linkOne));
    action.moveToElement(linkOne).click().perform();

    //Dismiss modal dialogue
    driver.findElement(By.cssSelector(".show")).click();