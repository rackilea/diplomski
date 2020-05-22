public class Main {
    public static void main(final String[] args) {
        Device device = new Device();
        HelloMessageHandler helloMessageHandler = new HelloMessageHandler();
        device.registerHandler(MessageType.HELLO.class, helloMessageHandler);

        HelloMessage helloMessage = new HelloMessage("abhinav");
        HelloResponse helloResponse = device.send(helloMessage);
        System.out.println(helloResponse.getGreeting());
    }
}