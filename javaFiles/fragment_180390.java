public void StaleElementHandleByID (String elementID){
int count = 0;
boolean clicked = false;
while (count < 4 || !clicked){
    try {
       WebElement yourSlipperyElement= driver.findElement(By.id(elementID));
       yourSlipperyElement.click(); 
       clicked = true;
     } catch (StaleElementReferenceException e){
       e.toString();
       System.out.println("Trying to recover from a stale element :" + e.getMessage());
       count = count+1;
     }     
}