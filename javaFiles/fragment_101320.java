List<WebElement> chkbx =driver.findElements(By.xpath("//input[@type='checkbox']"));
for(WebElement e:chkbx) 
{ 
    if(e.isDisplayed()) 
    {
       e.click(); 
       Thread.sleep(1500);
    } 
}