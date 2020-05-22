public class PageObject extends LoadableComponent<PageObject>{

    public PageObject() throws Exception {
        driver = getWebDriver();
        PageFactory.initElements(driver, this);
        isLoaded();
    }
    private WebDriver driver = null;

    @FindBy(id = "yourButton")
    private WebElement button;

    @FindBy(id = "textBoxThatAppears")
    private WebElement txtBox;

    @Override
    public void isLoaded() throws Error {
        // Initial loading, called when creating the page object to make sure that the page is loaded to a state where it is ready to interact with us, in our case it means that button is present in DOM and visible.
        waitForVisibility(button);
    }

    private void waitForVisibility(WebElement element) throws Error{
           new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void clickButton(){
        button.click();

    }

    public void interactWithTextbox(String text){
        // Wait for txtBox to be visible, then send text
        waitForVisibility(txtBox);
        txtBox.sendKeys(text);

       // EDIT 27.04.14: 
       // Actually you should not do the assertion here or anywhere in 
       // the pageObject, because when reusing the method in some other test, you might
       // not want to assert, you might wonder that why wouldn't you assert some 
       // specific condition every time, but I would throw that question right back 
       // to you and ask: What is the point of checking the exact same thing over and 
       // over again. There are 2 things, firstly the assertion takes resources (and
       // that can become important when test suite grows, secondly your tests can 
       // simply start failing at the same point when one little condition is not as
       // it should be. Also, having the asserts in the test, makes the test more
       // readable and understandable for others.
         // end edit 27.04.14
        // Next line is no longer recommended by this answer.
         // assert that something happened that you expected.
    }

}