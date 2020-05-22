if(driver.findElement(By.id("reports").size()!=0){

   WebElement menuHoverLink = driver.findElement(By.id("reports"));
   actions.moveToElement(menuHoverLink).perform();

   }
   else{
   system.out.println("element not present -- so it entered the else loop");

}