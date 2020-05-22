@Override
    public void sessionDestroyed(HttpSessionEvent se) {

    HttpSession httpSession = se.getSession();

    long lastAccessedTime = httpSession.getLastAccessedTime();
    int maxInactiveTime = httpSession.getMaxInactiveInterval();

     if ((System.currentTimeMillis() - lastAccessedTime) >= (maxInactiveTime*1000) {
         LOG.log(Level.INFO, "DEBUG: SESION DESTRUIDA");
   }