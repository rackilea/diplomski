public void loingClick(WebDriver driver,WebElement element, int numberOfSeconds) throws Exception
{
  Actions action = new Actions(driver);
  action.clickAndHold(element).build().perform();
  Thread.sleep(1000*numberOfSeconds);
  action.moveToElement(element).release();
}