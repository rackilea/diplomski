public class ApplicationContextListener implements HttpSessionListener {

  public void sessionCreated(HttpSessionEvent event) {
    ConcurrentMap<ServletContext, Set<HttpSession>> instance = SessionMap.getInstance();
    synchronized (instance) {
      ServletContext c = event.getSession().getServletContext();
      Set<HttpSession> set = instance.get(c);
      if (c == null) {
        set = new HashSet<HttpSession>();
        instance.put(c, set);
      }
      set.add(event.getSession());
    }
  }

  public void sessionDestroyed(HttpSessionEvent event) {
    ConcurrentMap<ServletContext, Set<HttpSession>> instance = SessionMap.getInstance();
    synchronized (map) {
      ServletContext c = event.getSession().getServletContext();
      Set<HttpSession> set = instance.get(c);
      if (c != null) {
        set.remove(event.getSession());
      }
    }
  }

}