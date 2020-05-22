javax.servlet.http.HttpSession session = event.getSession();
long lastAction = session.getLastAccessedTime();
long now = System.currentTimeMillis();
int timeout= getMaxInactiveInterval();
if ((now-lastAction) > timeout)
   //the session has timed out

SecurityContext context = getSecurityContext();
Authentication authentication = context.getAuthentication();
if (!authentication.isAuthenticated())
   //the user has logged out