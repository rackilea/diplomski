public class HandshakeResponse extends Message {
    private static final long serialVersionUID = 1L;
    private final HandshakeResult handshakeResult;

    public HandshakeResponse(HandshakeResult handshakeResult) {
        this.handshakeResult = handshakeResult;
    }

    public HandshakeResult getHandshakeResult() {
        return handshakeResult;
    }
}