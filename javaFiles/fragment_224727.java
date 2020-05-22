public class SessionStoringListener implements HttpSessionListener {

    private Map<String, HttpSession> sessions = new ConcurrentHashMap<String, HttpSession>();

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent)
    {
        HttpSession session = httpSessionEvent.getSession();
        sessions.put(session.getId(), session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent)
    {
        sessions.remove(httpSessionEvent.getSession().getId());
    }
}