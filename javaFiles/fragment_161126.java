@Test
public void test() {
    System.out.println("Executing test");

    //add this line of code to initialize elements via Page Factory
    loginPage = new LoginPageFactory(driver);

    loginPage
    .fillUsernameField("ivailostefanov1989@gmail.com")
    .fillPasswordField("astral8909")
    .clickSubmit(); 
}