class Messages {
    @JsonProperty("user")
    String user;

    @JsonProperty("messageList")
    List<Message> messageList;


    @JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, 
            property="type")
    @JsonSubTypes( {
            @JsonSubTypes.Type(value=TypeAMessage.class, name="typeA"),
            @JsonSubTypes.Type(value=TypeBMessage.class, name="typeB")
    })

    static class Message {}

    static class TypeAMessage extends Message {
        @JsonProperty("a")
        String a;
        @JsonProperty("b")
        int b;
    }

    static class TypeBMessage extends Message {
        @JsonProperty("c")
        boolean c;
        @JsonProperty("d")
        boolean d;
    }
}