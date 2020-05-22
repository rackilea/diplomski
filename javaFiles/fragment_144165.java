public class LogInPage
{
    @FindBy(id="userName")
    private WebElement userName;

    @FindBy(id="password")
    private WebElement password;

    public LogInPage() {
        PageFactory.initElements(driver, this); // initialize the members like driver.findElement()
    }

    public void doLogIn() {
        userName.sendKeys("qwe");
        password.sendKeys("123");
    }
}