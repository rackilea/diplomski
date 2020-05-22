public class HomePage {

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchTerms;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this)
    }

    /**
     * Perform a Google search
     *
     * @param searchString Search query
     */
    public void searchFor(String searchString) {
        searchTerms.clear();
        searchTerms.sendKeys(searchString);
        searchTerms.submit();
    }
}