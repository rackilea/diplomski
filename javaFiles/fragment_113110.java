@WebListener
public class MyApplication implements ServletContextListener {

    private final static String SERVER_CONTAINER_ATTRIBUTE = "javax.websocket.server.ServerContainer";

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext container = sce.getServletContext();

        final ServerContainer serverContainer = (ServerContainer) container.getAttribute(SERVER_CONTAINER_ATTRIBUTE);
        try {
            serverContainer.addEndpoint(new MyEndpointConfig(MyEndpoint.class, "/wstest"));
        } catch (DeploymentException e) {
            e.printStackTrace();
        }
    }
}