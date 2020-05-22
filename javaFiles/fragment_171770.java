driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

if (driver.findElements(By.cssSelector("//*[@title=\"Override total tax amount\"]")).size()!=0)
{
    driver.findElement(By.cssSelector("//*[@title=\"Override total tax amount\"]")).click();
}
else
{
     JLog.fail("Unable to find a writable item taxdialog!");
}