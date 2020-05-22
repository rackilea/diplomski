public class LoginPage extends WebPage {
    public LoginPage() {
      // first, login the user, then check were to send him/her:
      continueToOriginalDestination();
      // Magic! If we get this far, it means that we should redirect the
      // to the default page.
      setResponsePage(HomePage.class);
    }
  }