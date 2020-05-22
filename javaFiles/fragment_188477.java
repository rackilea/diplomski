wait.until(new ExpectedCondition<WebElement>() {      
           @Override public WebElement apply(WebDriver webDriver) {            
               try {
                   WebElement element = webDriver.findElement(By.<...>); // however you can locate MessageLogPage.messageStatus
                   if(element.getText().equals("yyy")) {
                       return element;
                   }      
                }
                catch(Exception e) { } // keep going (retun null)
                return null;                
        });