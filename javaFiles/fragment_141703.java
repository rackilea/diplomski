System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
WebDriver driver= new FirefoxDriver();
driver.get("https://www.facebook.com/");
String parent= driver.getWindowHandle();
System.out.println("Parent Window is"+parent);
driver.findElement(By.linkText("Data Policy")).click();
WebDriverWait wait = new WebDriverWait(driver,5);
wait.until(ExpectedConditions.numberOfWindowsToBe(2));
Set<String> s1= driver.getWindowHandles();
for(String s2:s1)
{
    if(!parent.equalsIgnoreCase(s2))
        {
            driver.switchTo().window(s2);
            Thread.sleep(5000);
            System.out.println(driver.getWindowHandle());
            System.out.println("get title of window"+driver.getTitle());
        }
}