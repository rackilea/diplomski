class ConnectionUtil {
    public static final ThreadLocal<Connection> connection = new ThreadLocal<Connection>();
}

public Return method(Args arg) {
    ConnectionUtil.connection.set(newConnection());
    try {
        ...
    } finally {
        ConnectionUtil.connection.remove();
    }
}