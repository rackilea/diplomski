@ApplicationScoped
public class GlobalevHttpSessionController {
  public static final String 
    EVENT_ATTRIBUTE_NAME = "HttpSessionControllerEvent";

  private final List _httpSessions = new ArrayList();

  public List getHttpSessions() {
    return new ArrayList(_httpSessions);
  }

  public void addSession(final HttpSession httpSession) {
    _httpSessions.add(httpSession);
  }

  public void removeSession(final HttpSession httpSession) {
    _httpSessions.remove(httpSession);
  }

  public void fireEvent(final GlobalEvent eventObject) {
    for (final HttpSession session : _httpSessions) {
      fireEvent(session, eventObject);
    }
  }

  private void fireEvent(final HttpSession session, final GlobalEvent eventObject) {
    try {
      final List globalEvents = getGlobalEvents(session);

      globalEvents.add(eventObject);
    } catch (final Exception e) {
      throw new IllegalStateException("fireEvent", e);
    }
  }

  private synchronized List getGlobalEvents(final HttpSession session) {
    List globalEvents = (List) session.getAttribute(EVENT_ATTRIBUTE_NAME);

    if (globalEvents == null) {
      globalEvents = new ArrayList();
      session.setAttribute(EVENT_ATTRIBUTE_NAME, globalEvents);
    }

    return globalEvents;
  }
}