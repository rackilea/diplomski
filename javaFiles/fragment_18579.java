public class Builder {

    private User sender = null;
    // Other properties

    public Builder sender( User sender ) {
        this.sender = sender;
        return this;
    }
    // Methods for other properties

    public Message build() {
        Message message = new Message();
        message.setSender( sender );
        // Set the other properties
        return message;
    }

}