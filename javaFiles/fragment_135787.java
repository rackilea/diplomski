public class APPDBConnection implements Connection {
    private final Connection connection;

    public APPDBConnection(final Connection connection) {
        this.connection = connection;
    }