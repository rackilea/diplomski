public class Bwinbe {
     public static void main(String[] args) {    
         System.setProperty("webdriver.chrome.driver", "mypath");
         WebDriver driver = new ChromeDriver();
         driver.get("http://test.www.bwin.be/");
         WebDriverWait wait = new WebDriverWait(driver,20);

         driver.findElement(By.id("login-overlay-button")).click();
         wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
         driver.findElement(By.id("username")).sendKeys("passport3");
         driver.findElement(By.id("password")).sendKeys("qwe123");
         driver.findElement(By.id("submit")).click();
        }
    }