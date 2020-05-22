import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MTSignOnPage extends BasePageObject {

    public MTSignOnPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[contains(@src,'mast_signon')]")
    WebElement pageHeader;
    @FindBy(name = "userName")
    WebElement userName;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(name = "login")
    WebElement submit;

    public boolean pageLoaded() {
        return helper.isDisplayed(pageHeader);
    }

    public void setUserName(String name) {
        helper.sendKeys(userName, name);
    }

    public void setPassword(String pword) {
        helper.sendKeys(password, pword);
    }

    public void clickSubmit() {
        helper.click(submit);
    }

}