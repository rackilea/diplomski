// obtain the list of error divs
    List<WebElement> errorDivs = driver.findElements(By.xpath("//div[@class='errorMsg']"));

    // if there is at east one element present
    if(!errorDivs.isEmpty()){
        // pick first one and use as main failure reason
        fail(errorDivs.get(0).getText());
    }

    // otherwise proceed with additional verifications
    assertEquals(actualTitle, title,"Home is not accessible!");