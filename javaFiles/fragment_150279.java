/**
 * Step Definition implementation class for Cucumber Steps defined in Feature file
 */

public class HomePageSteps extends BaseSteps {

    TestContext testContext;

    public HomePageSteps(TestContext context) {
        testContext = context;
    }

    @When("^User is on Brand Home Page (.+)$")
    public void user_is_on_Brand_Home_Page(String siteName) throws InterruptedException {
        homePage = new HomePage().launchBrandSite(siteName);
        testContext.scenarioContext.setContext(Context.HOMEPAGE, homePage);
    }

    @Then("^Clicking on Sign In link shall take user to Sign In Page$")
    public void clicking_on_Sign_In_link_shall_take_user_to_Sign_In_Page() {
        homePage = (HomePage) testContext.scenarioContext.getContext(Context.HOMEPAGE);
        signInPage = homePage.ecommSignInPageNavigation();
        testContext.scenarioContext.setContext(Context.SIGNINPAGE, signInPage);
    }