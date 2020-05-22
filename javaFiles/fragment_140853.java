List<WebElement> allOptions = dropDown.findElements(By."OUR Locator");
    for ( WebElement we: allOptions) { 
        dropDown.sendKeys( Keys.DOWN ); //simulate visual movement
        sleep(250);       
        if ( we.getText().contains( text ) ) select.selectByVisibleText("Value1");
    }