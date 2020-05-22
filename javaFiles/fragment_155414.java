public class MySessionListener implements HttpSessionListener {

    static public Map<String, HttpSession> getSessionMap(ServletContext appContext) {
        Map<String, HttpSession> sessionMap = (Map<String, HttpSession>) appContext.getAttribute("globalSessionMap");
        if (sessionMap == null) {
            sessionMap = new ConcurrentHashMap<String, HttpSession>();
            appContext.setAttribute("globalSessionMap", sessionMap);
        }
        return sessionMap;
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        Map<String, HttpSession> sessionMap = getSessionMap(event.getSession().getServletContext());
        sessionMap.put(event.getSession().getId(), event.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        Map<String, HttpSession> sessionMap = getSessionMap(event.getSession().getServletContext());
        sessionMap.remove(event.getSession().getId());
    }
}