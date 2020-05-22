MTHeaderPage mtHeader;

@Given("I am on the Mercury Tours home page")
public void givenIAmOnTheMercuryToursHomePage() {
    driver.get("http://newtours.demoaut.com");
    helper.waitForPageToLoad();
    mtHeader = new MTHeaderPage(driver);
    if (driver.getTitle().equalsIgnoreCase("Welcome: Mercury Tours")) 
        test.logGivenPass("I am on the Mercury Tours home page");
    else {
        test.logGivenFail("I am on the Mercury Tours home page", 
                          "Current URL: " + driver.getCurrentUrl());
        fail();
    }
}

@When("I enter User Name <userName> and password <password>")
public void whenIEnterUserNameuserNameAndPasswordpassword(@Named("userName") String userName,
                                                          @Named("password") String password) {
    helper.waitForPageToLoad();
    mtHeader = new MTHeaderPage(driver);
    mtHeader.setUserName(userName);
    mtHeader.setPassword(password);
    test.logWhenPass("I enter User Name " + userName + " and password " + password);
}

@When("I click the sign-in link")
public void whenIClickTheSigninLink() {
    mtHeader.clickSignIn();
    test.logAndPass("I click the sign-in link");
}