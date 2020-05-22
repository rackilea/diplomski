WebElement divElement = OpenBrowser.driver.findElement(By.cssSelector("#chartContainerTicket"));  
 WebElement spanElements = divElement.findElement(By.cssSelector("span"));  
try{
     svgElements = spanElements.findElement(By.cssSelector("svg")); 

    }
    catch(StaleElementReferenceException e1 ){
         svgElements = spanElements.findElement(By.cssSelector("svg")); 

    }