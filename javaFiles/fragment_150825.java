public boolean waitForElement(String elementXpath, int timeOut) {

    try{                    
    WebDriverWait wait = new WebDriverWait(driver, timeOut); 
    boolean elementPresent=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)).isDisplayed());

    System.out.printf("%nElement is present [T/F]..? ")+elementPresent;
    }        
    catch(TimeoutException e1){e1.printStackTrace();elementPresent=false;}          

    return elementPresent;   
 }