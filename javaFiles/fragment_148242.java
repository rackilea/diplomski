interface MessageResponseHandler<T extends MessageBody> {
    public void responsed(Message<T> msg);
}

public class DeviceClientHelper<T extends MessageBody> {
    public MessageResponseHandler<T> messageHandler;

    void setHandler(MessageResponseHandler<T> h){
        this.messageHandler = h;
    }

    public void someMethod(Object message){
        Message<T> msg = (Message<T>) message;
        if (this.messageHandler != null) {
            this.messageHandler.responsed(msg);
        }
    }
}