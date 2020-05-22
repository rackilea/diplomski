public class EventHandler implements WebDriverEventListener
 {
    @Override
    public void afterNavigateTo(String arg0, WebDriver arg1) {
        System.out.println("Inside the afterNavigateTo to " + arg0);
    }

    @Override
    public void beforeNavigateTo(String arg0, WebDriver arg1) {
        System.out.println("Just before beforeNavigateTo " + arg0);
    }
 }