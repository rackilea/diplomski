public class ChatMessage {

    private final String userName;
    private final String message;

    public ChatMessage(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

}