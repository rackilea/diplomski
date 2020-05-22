public class ChromeTest {

  public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
        WebDriver driver = new ChromeDriver();              
        driver.get("http://www.test.com");

    }

}