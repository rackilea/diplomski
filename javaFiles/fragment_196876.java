public abstract class XMLSubscription <T extends XMLMessage> {
    private Class<T> messageType;

    protected XMLSubscription(Class<T> messageType) {
        this.messageType = messageType;
    }

    public Class<T> getExpectedMessageType() {
        return this.messageType;
    }
}

public class XMLStatusSubscription extends XMLSubscription<XMLStatusMessage> {

    public XMLStatusSubscription() {
        super(XMLStatusMessage.class);
    }
}