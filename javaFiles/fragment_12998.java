//Get the parent window handle
String parentHandle = driver.getWindowHandle();

for(String handle : driver.getWindowHandles())
{
    driver.switchTo().window(handle);

    //Since window handles are random in order, verify whether you are on the correct page  
    if(driver.getTitle().equalsIgnoreCase(<Title of the new page>))
    {
         //do whatever you wish to do on this page
         //once done, you may need to close this page
          driver.close();
          break;
    }           
}
//Switch back to the parent page
driver.switchTo().window(parentHandle);