public class Engine {
     public static void main(String[] args) {
    File filename = new File("F:\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", filename.getAbsolutePath());

        WebDriver driver = new ChromeDriver();
        driver.get("www.google.com");
     }