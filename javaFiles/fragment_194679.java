abstract class IdentifiedConnection extends Connection {

    private UUID uuid;

    public IdentifiedConnection(String serverAddress,
                                int port,
                                Supplier<UUID> uuidSupplier) throws IOException {
        super(serverAddress, port);
        this.uuid = uuidSupplier.get();
    }
}