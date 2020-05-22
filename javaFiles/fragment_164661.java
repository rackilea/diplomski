public class session_listener implements HttpSessionListener,ServletContextListener {
    public session_listener() {}
    @Override public void sessionCreated(HttpSessionEvent se) {
    //have a break-point and check stack to see who just created the session
}
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    //have a break-point and check stack to see who just destroyed the session
    }

    @Override public void contextInitialized(ServletContextEvent sce){}

    @Override public void contextDestroyed(ServletContextEvent sce) {}
}