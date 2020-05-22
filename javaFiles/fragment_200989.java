WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.attributeContains(progressBar, "style", "width: 100%;"));

    List<WebElement> pricelist= driver.findElements(By.cssSelector("ul#flightModuleList  div.offer-price.urgent > span.visuallyhidden"));

    for(WebElement e: pricelist){

        System.out.println("The prices are: " + e.getText());
    }