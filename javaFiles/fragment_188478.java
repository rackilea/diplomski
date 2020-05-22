wait.until(new ExpectedCondition<Boolean>() {      
           @Override public Boolean apply(WebDriver webDriver) {            
               try {
                   WebElement element = webDriver.findElement(By.<...>); // however you can locate MessageLogPage.messageStatus
                   return element.getText().equals("yyy");
               }
               catch(Exception e) { } // keep going (return false)
               return false;          
        });