public class InfoMessage extends Message {
    public InfoMessage(Message anotherMessage, String theMessage) {
        this.anotherMessage = anotherMessage;
        this.theMessage = theMessage;
    }
}