public class BuyProductPage extends WebPage {
      public BuyProductPage() {
        User user = session.getLoggedInUser();
        if (user  null) {
          throw new RestartResponseAtInterceptPageException(LoginPage.class);
        }
      }
  }