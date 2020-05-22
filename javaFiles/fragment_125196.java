try {
    WebDriverWait wait = new WebDriverWait(webDriver, timeinseconds1);
    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myDynamicElement")));
} catch (TimeOutException toe) {
  //handle the page not loading
}
//from now on continue the code as synchronous knowing that the page is loaded