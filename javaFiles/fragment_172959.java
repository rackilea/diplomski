String originalWindowHandle = driver.getWindowHandle();
java.util.Set<java.lang.String> windowHandles = driver.getWindowHandles();

for (String window: windowHandles) {

    //skip if parent window
    if(!window.equals(originalWindowHandle)){
        //if not parent switch to window
        driver.switchTo().window(window);
        //do whatever and use close window here to
        //close the child window        
    }  
    // if you are done switch back to parent`   
    driver.switchTo().window(originalWindowHandle);     
}