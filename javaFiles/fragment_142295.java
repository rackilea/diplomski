public class Login_Page {


@FindBy(id = "someId1")
WebElement link1;

@FindBy(id = "someId2")
WebElement link2;

//constructor
public Login_Page(driver) {
    PageFactory.initElements(driver, this);
}

//Generic Click method
public boolean genericClick(WebDriver driver, WebElement elementToBeClicked)
{

    try{

     elementToBeClicked.click();

     return true;
}
catch(Exception e){

     return false;
}

}