/**
 * Set the connect timeout for the socket.
 * @param connectTimeout the timeout
 */
public void setConnectTimeout(int connectTimeout) {
     this.connectTimeout = connectTimeout;
}

/**
 * Set the (socket option) timeout on the command socket.
 * @param defaultTimeout the timeout.
 */
public void setDefaultTimeout(int defaultTimeout) {
    this.defaultTimeout = defaultTimeout;
}

/**
 * Set the (socket option) timeout on the data connection.
 * @param dataTimeout the timeout.
 */
public void setDataTimeout(int dataTimeout) {
    this.dataTimeout = dataTimeout;
}