import java.util.HashMap;
import java.util.Map;

public class Device {

    @SuppressWarnings("rawtypes")
    private final Map<Class<? extends MessageType>, MessageHandler> handlers =
        new HashMap<Class<? extends MessageType>, MessageHandler>();

    public <T extends MessageType, M extends Message<T>, R extends Response<T>> 
        void registerHandler(
            final Class<T> messageTypeCls, final MessageHandler<T, M, R> handler) {
        handlers.put(messageTypeCls, handler);
    }

    @SuppressWarnings("unchecked")
    private <T extends MessageType, M extends Message<T>, R extends Response<T>> 
        MessageHandler<T, M, R> getHandler(final Class<T> messageTypeCls) {
        return handlers.get(messageTypeCls);
    }


    public <T extends MessageType, M extends Message<T>, R extends Response<T>> 
        R send(final M message) {
        MessageHandler<T, M, R> handler = getHandler(message.getTypeClass());
        R resposnse = handler.handle(message);
        return resposnse;
    }

}