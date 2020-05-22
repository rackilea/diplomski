DefaultSecurityManager securityManager = (DefaultSecurityManager) SecurityUtils.getSecurityManager();
    DefaultSessionManager sessionManager = (DefaultSessionManager) securityManager.getSessionManager();
    Collection<Session> activeSessions = sessionManager.getSessionDAO().getActiveSessions();
    for (Session session: activeSessions){
         session.stop();
    }