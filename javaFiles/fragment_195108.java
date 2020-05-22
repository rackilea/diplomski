@Service
public class ClientHelloService implements MessageCallback {
  @Override
  public void callback(final Message message) {
    HttpSession session = message.getResource(
        HttpServletRequest.class, HttpServletRequest.class.getName()).getSession();
    System.out.println("Client said hello. Session ID: " + session.getId());
  }
}