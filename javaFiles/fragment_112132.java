public class practiceExample2 {

public static void main(String[] args) throws AWTException {
    System.setProperty("webdriver.chrome.driver", "G:\\TopsAssignment\\SampleJavaExample\\lib\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("https://www.facebook.com/");
    WebElement elm1 = driver.findElement(By.name("firstname"));
    String test = elm1.getText();
    System.out.println(test);


    WebElement elm2 = driver.findElement(By.name("lastname"));


    Actions cpypast = new Actions(driver);
    cpypast.sendKeys(elm1,"Pratik").doubleClick().contextClick().build().perform();

    Robot rb = new Robot();
    rb.keyPress(KeyEvent.VK_DOWN);
    rb.keyRelease(KeyEvent.VK_DOWN);
    rb.keyPress(KeyEvent.VK_DOWN);
    rb.keyPress(KeyEvent.VK_ENTER);
    rb.keyRelease(KeyEvent.VK_DOWN);
    rb.keyRelease(KeyEvent.VK_ENTER);

    Actions cpypast1 = new Actions(driver);

    cpypast1.contextClick(elm2).build().perform();

    rb.keyPress(KeyEvent.VK_DOWN);
    rb.keyRelease(KeyEvent.VK_DOWN);
    rb.keyPress(KeyEvent.VK_DOWN);
    rb.keyPress(KeyEvent.VK_ENTER);
    rb.keyRelease(KeyEvent.VK_DOWN);
    rb.keyRelease(KeyEvent.VK_ENTER);

    String str = elm2.getText();
    System.out.println(str);

    driver.close();

}