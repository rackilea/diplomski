@FindBy(how = How.XPATH, using = "//*")
public WebElement all;

public WebElement getAddCustomerButton(){
    BrowserDriver.switchTo().frame(0);
    WebElement button = BrowserDriver.getText(all, "Add customer");
    return button;
}