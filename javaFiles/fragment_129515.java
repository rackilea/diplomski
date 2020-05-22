public static void main(String[] args) 
{

System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Selenium\\Web Drivers\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
driver.get("https://www.aboutyou.de/p/hugo/buegelleichtes-hemd-elvor-3636873");
//Scrolling down
((JavascriptExecutor)driver).executeScript("scroll(0,400)");

//Click the tab "produktdetails" in which PRODUKMABE exists
driver.findElement(By.xpath("//div[@class='btn-tab V3adp__productDescriptionTab V3adp__productDescriptionTab--1outOf4'][2]")).click();
String size = driver.findElement(By.xpath("//div[@class='description-text bottom-0']/h5")).getText();
System.out.println(size);

}