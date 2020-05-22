System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.facebook.com");
WebElement dropDown = driver.findElement(By.id("month"));
Select select = new Select(dropDown);
List<WebElement> options = select.getOptions();
ArrayList<String> months = new  ArrayList<>();
for(WebElement we : options)
    months.add(we.getText());
System.out.println("Current list of months: " +months);