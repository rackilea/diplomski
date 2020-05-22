public abstract class AbstractGuiceWebSocketServlet extends WebSocketServlet {

    @Inject Injector injector;

    @Override
    protected StreamInbound createWebSocketInbound(String subProtocol, HttpServletRequest request) {
        return injector.getInstance(serveWith());
    }

    public abstract Class<? extends StreamInbound> serveWith();

}