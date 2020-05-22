public class SomeClassName{

    @FindBy(xpath = "someXpathExpression") private WebElement dropDown;
    @FindBy(xpath = "someXpathExpression") private WebElement warningMessage;
    @FindBy(xpath = "someXpathExpression") private WebElement continueButton;

public void fillForm() throws Exception{
    WebElement valueFromDropDown = getDropDownValueRandomly();
    dropDown.click();
    valueFromDropDown.click();
    if(user will see that warningMessage suddenly apppears){
    dropDown.click();
    getDropDownValueRandomly().click(); -> this is where I want to click on another value
    }else{
    contunieButton.click();
    }
}

public WebElement getDropDownValueRandomly() {
    Random random = new Random();
    int x = random.nextInt(30) + 1;
    WebElement valueFromDropDown = driver.findElement(By.id("uxMiniFinderVoyageSelect_chzn_o_" + x));

    return valueFromDropDown;

}