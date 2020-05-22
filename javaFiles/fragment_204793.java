public Mymain(String username, String password) throws IOException, XMPPException, NullPointerException, InterruptedException, InvocationTargetException {
    ConnectionConfiguration config = new ConnectionConfiguration("talk.google.com", 5222, "gmail.com");
    connection = new XMPPConnection(config);
    connection.connect();
    connection.login(username, password);
    name = username;

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // This is a new instance of MyMain, so the connection
                // you just created is relevant...
                new Mymain().setVisible(true);
            } catch (NullPointerException | IOException | XMPPException ex) {
                Logger.getLogger(Mymain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
}