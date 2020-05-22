public Mymain(XMPPConnection connection) {
    this.connection = connection;
    initComponents();
    setVisible(true);
}

try {

    String username, String password) throws IOException, XMPPException, NullPointerException, InterruptedException, InvocationTargetException {
    ConnectionConfiguration config = new ConnectionConfiguration("talk.google.com", 5222, "gmail.com");
    connection = new XMPPConnection(config);
    connection.connect();
    connection.login(username, password);
    new MyMain(connection);
} catch (IOException | XMPPException | NullPointerException | InterruptedException | InvocationTargetException exp) {
    exp.printStackTrace();
}