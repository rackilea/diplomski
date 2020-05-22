//handle of the master window before clicking the link
String master = driver.getWindowHandle();

driver.findElement(By.linkText("Click me")).click();

//logic for waiting for the popup, checking the size to become greater than 1 or breaking after sometime to avoid the infinite loop.
int timeCount = 1;

do
{
   driver.getWindowHandles();
   Thread.sleep(200);
   timeCount++;
   if ( timeCount > 50 ) 
   {
       break;
   }
}
while ( driver.getWindowHandles().size == 1 );

//Assigning the handles to a set
Set<String> handles = driver.getWindowHandles();
//Switching to the popup window.
for ( String handle : handles )
{
    if(!handle.equals(master))
    {
         driver.switchTo().window(handle);
    }
}