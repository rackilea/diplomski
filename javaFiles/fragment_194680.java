class SomeConnection extends IdentifiedConnection {

    public SomeConnection(String serverAddress, int port) throws IOException {
        super(serverAddress, port, SomeConnection::createUUID);
    }

    public static UUID createUUID() {
        return ...;
    }

}