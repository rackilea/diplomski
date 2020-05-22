@WebListener
public class GlobalevHttpSessionListener implements HttpSessionListener {
  @Inject
  private GlobalevHttpSessionController _httpSessionController;

  public void sessionCreated(final HttpSessionEvent se) {
    _httpSessionController.addSession(se.getSession());
  }

  public void sessionDestroyed(final HttpSessionEvent se) {
    _httpSessionController.removeSession(se.getSession());
  }
}