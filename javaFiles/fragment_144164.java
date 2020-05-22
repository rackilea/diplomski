public class LogInPage
{
    private WebElement userName;
    private WebElement password;

    public LogInPage() {
    }

    public void locateElements() {
        userName = driver.findElement(By.id("userName"));
        password = driver.findElement(By.id("password"));
    }

    public void doLogIn() {
        userName.sendKeys("qwe");
        password.sendKeys("123");
    }
}