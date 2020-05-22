public BasePage enterValue(String inputText) {
  driver.findElement(By.id("someId")).sendKeys(inputText);
    if(isAlertPresent){
      return new ProductAlertPage(driver);
    } else if (isErrorDisplayed) {
      return new ErrorPage(driver);
    } else {
      return this;
   }
}