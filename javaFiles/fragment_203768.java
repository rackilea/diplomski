@WebListener
public class UserSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
    System.out.println("Session Created");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
    System.out.println("Session Destroyed");

    }

}