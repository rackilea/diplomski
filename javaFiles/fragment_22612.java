/**
 * ACTIVE_LOCAL_DATA_CONNECTION_MODE = 0 <br>
 * A constant indicating the FTP session is expecting all transfers
 * to occur between the client (local) and server and that the server
 * should connect to the client's data port to initiate a data transfer.
 * This is the default data connection mode when and FTPClient instance
 * is created.
 * PASSIVE_LOCAL_DATA_CONNECTION_MODE = 2 <br>
 * A constant indicating the FTP session is expecting all transfers
 * to occur between the client (local) and server and that the server
 * is in passive mode, requiring the client to connect to the
 * server's data port to initiate a transfer.
 *
 * @param clientMode The client mode.
 */
public void setClientMode(int clientMode) {