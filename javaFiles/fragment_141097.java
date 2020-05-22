driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
// then follows your code:
if(!driver.findElements(By.id(AppConstants.notificationcount)).isEmpty())
{

  // DO SOMETHING

}
else
{

   System.out.println("No Element available");    
}