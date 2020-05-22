int size = driver.findElements("Locator").size();
    if(size!=0){
         if(driver.findElement("Locator").isDisplayed()){
             // do operations
         }
    }