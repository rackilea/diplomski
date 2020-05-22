public class Main{

static WebDriver driver = new FirefoxDriver();

public static void main(String [] args) throws InterruptedException{

    WebElement un = driver.findElement(By.id("login_username_id"));
    un.sendKeys(username);
    WebElement pwd = driver.findElement(By.id("login_password_id"));
    pwd.sendKeys(password);

    waitForElement(By.id("ur id"),60);

    driver.findElement(By.id("login_submit_id")).click();

    waitForElement(By.id("ur id"),60);


}

/**
 * wait until expected element is visible
 *
 * @param   expectedElement     element to be expected
 * @param   timeout             Maximum timeout time
 */
public static void waitForElement(By expectedElement, int timeout) {
    try {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(expectedElement));

    } catch (Exception e) {
        e.printStackTrace();
        //System.out.println("print ur message here");
    }
}
}