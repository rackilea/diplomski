public class AlertMessage extends Message {
    public AlertMessage(Message anotherMessage, String theMessage) {
        this.anotherMessage = anotherMessage;
        this.theMessage = theMessage;
    }
}