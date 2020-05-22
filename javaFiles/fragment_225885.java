// fill first field
    WebElement textInput = driver.findElement(By.xpath("//input[@id='fromStation']"));
    textInput.sendKeys("Warszawa");
    Thread.sleep(5000);
    String firstElementXPath = "(//div[@id='fromStation-cg']//div[@class='tt-station tt-suggestion tt-selectable']//span)[1]";
    WebElement firstElementDiv = driver.findElement(By.xpath(firstElementXPath)); //NoSuchElementException
    wait.until(ExpectedConditions.elementToBeClickable(firstElementDiv));
    System.out.println(firstElementDiv.getText());
    firstElementDiv.click();