public  void adminViaDropDown(int index) {
          WebElement myDynamicElement = (new WebDriverWait(driver, 10))
  .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));  
          Select drop = new Select(myDynamicElement );
          drop.selectByIndex(index);  
    }