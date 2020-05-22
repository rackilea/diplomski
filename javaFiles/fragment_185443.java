public class ErrorMessage extends Message {
    public ErrorMessage(Message anotherMessage, String theMessage) {
        this.anotherMessage = anotherMessage;
        this.theMessage = theMessage;
    }
}