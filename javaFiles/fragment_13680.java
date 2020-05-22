public class ChatMessage {

    private String uid;
    private String name;
    private String message;
    private Long creationTime;

    public ChatMessage() {
        // Default constructor required for calls to DataSnapshot.getValue(ChatMessage.class)
    }

    public ChatMessage(String uid, String name, String message) {
        this.uid = uid;
        this.name = name;
        this.message = message;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public java.util.Map<String, String> getCreationTime() {
        return ServerValue.TIMESTAMP;
    }

    @Exclude
    public Long getCreationTimeLong() {
        return creationTime;
    }

    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }
}