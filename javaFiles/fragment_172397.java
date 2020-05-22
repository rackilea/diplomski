public class MessageFactory implements IValues {
    private static final Object LOCK = new Object();

    public static Message createRegisterRequest(String name, String password) {
        synchronized(LOCK){
            Payload payload = createPayload(name, password);
            return new Message(VALUE_REGISTRATION, payload);
        }
    }
}