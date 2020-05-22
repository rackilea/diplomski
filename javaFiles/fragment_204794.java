public Mymain(String username, String password) throws IOException, XMPPException, NullPointerException, InterruptedException, InvocationTargetException {
    initComponents();
    welcome.setText(name);

    ConnectionConfiguration config = new ConnectionConfiguration("talk.google.com", 5222, "gmail.com");
    connection = new XMPPConnection(config);
    connection.connect();
    connection.login(username, password);
    name = username;

    setVisible(true);
}