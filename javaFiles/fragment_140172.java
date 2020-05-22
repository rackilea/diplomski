public class SingleWebSocketCreator implements WebSocketCreator
{
    private Class<?> endpoint;

    public SingleWebSocketCreator(Class<?> websocketEndpoint)
    {
        this.endpoint = websocketEndpoint;
    }

    @Override
    public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp)
    {
        try
        {
            // new instance of endpoint for each upgrade
            return endpoint.newInstance();
        }
        catch (InstantiationException | IllegalAccessException e)
        {
            // failure to instantiate can flow out
            throw new RuntimeException(e);
        }
    }
}