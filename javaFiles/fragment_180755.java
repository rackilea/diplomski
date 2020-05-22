public void sessionCreated(HttpSessionEvent event) {
    synchronized (this) {
        ServletContext application = event.getSession().getServletContext();
        sessionCount = (Integer) application.getAttribute("SESSION_COUNT");
        if (sessionCount == null) {
            application.setAttribute("SESSION_COUNT", (sessionCount = 1));//setting sessioncount inside application scope
        } else {
            application.setAttribute("SESSION_COUNT", sessionCount + 1);
        }
        System.out.println("Session Created1: "+ event.getSession().getId());
        System.out.println("Total Sessions1: " + sessionCount);
    }
}

public void sessionDestroyed(HttpSessionEvent event) {
    synchronized (this) {
        ServletContext application = event.getSession().getServletContext();
        sessionCount = (Integer) application.getAttribute("SESSION_COUNT");
        application.setAttribute("SESSION_COUNT", sessionCount - 1);
    }
    System.out.println("Session Destroyed: " + event.getSession().getId());
    System.out.println("Total Sessions: " + sessionCount);
}