/**
 * Spin-up Neo4j server with loaded unmanaged extension.
 */
public final class Neo4jTestServer {

    public static final String EXTENSION_MOUNT_POINT = "/ext";
    public static final String EXTENSION_RESOURCES = "my.company.extension.resources";
    // Alternative way to get package
    // public static final String EXTENSION_RESOURCES = SomeResource.class.getPackage().getName();

    private static Neo4jTestServer INSTANCE = null;

    public static synchronized Neo4jTestServer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Neo4jTestServer();
        }
        return INSTANCE;
    }

    private final ServerControls serverControls;

    private Neo4jTestServer() {
        serverControls = TestServerBuilders.newInProcessBuilder()
            .withExtension(EXTENSION_MOUNT_POINT, EXTENSION_RESOURCES)
            // Resource can be specified directly
            // .withExtension(EXTENSION_MOUNT_POINT, SomeResource.class)
            .newServer();
    }

    public ServerControls getServerControls() {
        return serverControls;
    }

    public void shutdown() {
        serverControls.close();
    }
}