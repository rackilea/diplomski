public class JettyStartingListener extends AbstractLifeCycleListener {

    private final ServletContext sc;

    public JettyStartingListener(ServletContext sc){
        this.sc = sc;
    }

    @Override
    public void lifeCycleStarting(LifeCycle event) {
        try {
            new I().onStartup(new HashSet<Class<?>>(), sc);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

}

Server server = new Server(8080);
ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
context.setContextPath("/");
server.setHandler(context);
context.addLifeCycleListener(new JettyStartingListener(context.getServletContext()));
server.start();
server.join();