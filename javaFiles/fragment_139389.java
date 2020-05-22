public class LogoutTest extends TestCase {

    public void testLogout() throws IOException, SAXException {

        new Config().initApplication()
                .doLogin("user", "pass") // returns WelcomePage class
                .goToFilterPage()  //Returns another page
                .doLogout();  //returns LoginPage class
    }
   }