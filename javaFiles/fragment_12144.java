public class NewSignUpFlowStepDefinitions {

    private final LoginPage poLogin;
    private final SignUpPage poSignup;

    NewSignUpFlowStepDefinitions(LoginPage poLogin, SignUpPage poSignup) {
        this.poLogin = poLogin;
        this.poSignup = poSignup;
    }

    @Given("I am on Login Page")
    public void iAmOnLoginPage() {
        assertThat("ON LOGIN PAGE", poLogin.isLoginScreen(), equalTo(true));
    }

    @When("I tap on Sign Up Link")
    public void iTapsOnSignUpLink() {
        poLogin.clickSignUp();
    }

}