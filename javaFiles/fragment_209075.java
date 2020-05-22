public class MyClass {

    WebDriverWait wait; 
    WebDriver driver; 
    @FindBy(how=How.ID, id="locatorId")
    WebElement locator; 

    // Construct your class here 
    public MyClass(WebDriver driver){
        this.driver = driver; 
        wait = new WebDriverWait(driver,30);
    }

    // Call whatever function you want to create 
    public void MyFunction(){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        // Perform desired actions that you wanted to do in myClass
    }