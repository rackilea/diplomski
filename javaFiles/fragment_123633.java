public class Test_Chromedriver {
    public static WebDriver driver; 
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver","E:\\jars\\chromedriver.exe");
            driver=new ChromeDriver(); // <- remove the Webdriver type
            driver.get("http://www.facebook.com");
            driver.findElement(By.id("email")).sendKeys("surya");
            driver.findElement(By.name("pass")).sendKeys("hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            driver.close();
            driver.quit();
        }
    }
}