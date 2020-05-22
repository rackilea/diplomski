try {
  if(webDriver.findElementByXPath(btn).isDisplayed()){
     //conditions
  }
  else{
     conditionsForNotDisplay();
  }
} catch (Exception e) {
  //log exception
  conditionsForNotDisplay();

}