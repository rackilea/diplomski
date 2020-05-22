public class Test_Chromedriver {
    public static WebDriver driverNULL; // <- never instantiate
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver","E:\\jars\\chromedriver.exe");
            WebDriver driverOK=new ChromeDriver(); // < - local variable
            driverOK.get("http://www.facebook.com");
            driverOK.findElement(By.id("email")).sendKeys("surya");
            driverOK.findElement(By.name("pass")).sendKeys("hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            driverNULL.close(); // <- want to close a object never instantiate so null pointer exception
            driverNULL.quit();
        }
    }
}