public interface MessageHandler<T extends MessageType, M extends Message<T>, R extends Response<T>> {
    R handle(M message);
}

public class HelloMessageHandler 
    implements MessageHandler<MessageType.HELLO, HelloMessage, HelloResponse> {
    @Override
    public HelloResponse handle(final HelloMessage message) {
        return new HelloResponse(message.getName());
    }
}