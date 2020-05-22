public class LoginPage extends WebPage {
    public LoginPage() {
      // first, login the user, then check were to send him/her:
      if (!continueToOriginalDestination()) {
        // redirect the user to the default page.
        setResponsePage(HomePage.class);
      }
    }
  }