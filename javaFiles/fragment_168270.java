public class FooPage {
    @FindBy(how = How.ID, using = "button1")
    public WebElement firstButton;

    //Missing button
    @FindBy(how = How.ID, using = "button2")
    public WebElement secondButton;

    public FooPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickThebuttons() {
        firstButton.click();

        try {
            secondButton.click();
        } catch (NoSuchElementException ex) {
            // Do something when the second button does not exist
        }
    }
}