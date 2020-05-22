if("input".equals(element.getTagName()){
   element.sendKeys("");
} 
else{
   new Actions(driver).moveToElement(element).perform();

}