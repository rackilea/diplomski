class Message {
    public final long sentAt; 
    public final String data;

    public Message(String data) {
        this.sentAt = System.currentTimeMillis()
        this.data = data;
    }

    public long timeSinceSent() {
        return System.currentTimeMillis() - sentAt;
    }
}