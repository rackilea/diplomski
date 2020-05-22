public class HelloMessage implements Message<MessageType.HELLO> {

    private final String name;

    public HelloMessage(final String name) {
        this.name = name;
    }

    @Override
    public Class<MessageType.HELLO> getTypeClass() {
        return MessageType.HELLO.class;
    }

    public String getName() {
        return name;
    }

}

public class HelloResponse implements Response<MessageType.HELLO> {

    private final String name;

    public HelloResponse(final String name) {
        this.name = name;
    }

    public String getGreeting() {
        return "hello " + name;
    }

}