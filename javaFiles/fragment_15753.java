@Component
public class SessionListener implements ApplicationListener<HttpSessionDestroyedEvent> {

    public void onApplicationEvent(HttpSessionDestroyedEvent evt) {
        HttpSession session = evt.getSession();
        // Your logic here
    }
}