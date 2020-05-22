public class BroadcastApplication extends WebSocketApplication { 

    private final Broadcaster broadcaster;

    public BroadcastApplication(Broadcaster broadcaster) {
        this.broadcaster = broadcaster; 
    }

    @Override
    public WebSocket createSocket(ProtocolHandler handler, 
            HttpRequestPacket requestPacket, WebSocketListener... listeners) {
        return new BroadcastWebSocket(broadcaster, handler, requestPacket, listeners);
    }

    @Override
    public void onMessage(WebSocket socket, String data) {
        socket.broadcast(getWebSockets(), data);
    }

    private static class BroadcastWebSocket extends DefaultWebSocket {

        public BroadcastWebSocket(Broadcaster broadcaster,
                ProtocolHandler protocolHandler,
                HttpRequestPacket request,
                WebSocketListener... listeners) {

            super(protocolHandler, request, listeners);
            this.broadcaster = broadcaster;
        }
    }
}