List<WebElement> nextVal=driver.findElements(By.xpath("//span[contains(@class,'np')][contains(text(),'Next')]"));
if(nextVal.size()>0){
     driver.findElement(By.xpath("//span[contains(@class,'np')][contains(text(),'Next')]")).click();
}
else{
  break;//exits while loop!
}