public void ClickButton () throws InterruptedException
{
WebElement button = driver.findElement(By.id("button"));
String Source = driver.getPageSource();
if (Source.contains(button))
    {
    button.click();
    Thread.sleep(3000);
    }
else
    {
    driver.quit;
    }
}