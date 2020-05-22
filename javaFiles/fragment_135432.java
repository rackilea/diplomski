public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "c:\\SRP\\chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");

    String newTab =null;
    String baseTab = driver.getWindowHandle();

    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

    Set <String> allTabs = driver.getWindowHandles();

    allTabs.remove(baseTab);

    Iterator<String> itr = allTabs.iterator();

    while(itr.hasNext()){


    newTab = (String) itr.next();

    }

    driver.switchTo().window(newTab);
    driver.get("http://www.gmail.com"); 

}