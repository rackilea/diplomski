public abstract class MessageBase {
    private final String destination;
    private final String uid;
    private String sender;

    public MessageBase(String destination) {
        // Invoke the more parameterized constructor
        this(destination, "");
    }

    public MessageBase(String destination, String uid) {
        this.destination = destination;
        this.uid = uid;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    // etc
}