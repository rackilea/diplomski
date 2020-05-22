WebDriver driver = new FirefoxDriver(); //Opening firefox instance

driver.manage().window().maximize(); //maximizing window
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //Giving implicit timeout of 20 seconds

driver.get("http://www.naukri.com/");


//Since there are two windows popping up, hence switching and closing the unnecessary window.
Set<String> windows = driver.getWindowHandles();        
Iterator iter = windows.iterator();
String parentWindow = iter.next().toString();
String childWindow = iter.next().toString();        
driver.switchTo().window(childWindow);
driver.close();
driver.switchTo().window(parentWindow);

//Hovering over "Jobs"
Actions act = new Actions(driver);
WebElement jobs = driver.findElement(By.xpath("//ul[@class='midSec menu']//div[.='Jobs']"));
act.moveToElement(jobs).build().perform();

//Clicking on "Advance Search"
WebElement Adv_search = driver.findElement(By.xpath("//ul[@class='midSec menu']/li[1]//a[.='Advanced Search']"));
act.moveToElement(Adv_search).click().perform();

//Clicking on the industry dropdown
driver.findElement(By.xpath("//div[@class='DDinputWrap']/input[contains(@placeholder,'Select the industry')]")).click();

//Selecting the checkbox containing text as "Accounting"
driver.findElement(By.xpath("//ul[@class='ChkboxEnb']//a[contains(text(),'Accounting')]")).click();

//Selecting the checkbox containing text as 'Government' 
driver.findElement(By.xpath("//ul[@class='ChkboxEnb']//a[contains(text(),'Government')]")).click();