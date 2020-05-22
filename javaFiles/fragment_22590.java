public static Connection newConnectionWithPassword(String host, String username, String passwd) {
    Connection newConn = new Connection(host);
    try {
        newConn.connect(); // Ignoring ConnectionInfo returned value.
        newConn.authenticateWithPassword(username, passwd);
        return newConn;
    } catch (IOException ioe) {
        newConn.close();
        ioe.printStackTrace();
        return null;
    }
}