public static void main(String args[]) {
    try {
        System.out.println("Connecting...");
        ConnectionConfiguration config = new ConnectionConfiguration("talk.google.com", 5222, "gmail.com");
        final XMPPConnection connection = new XMPPConnection(config);
        connection.connect();
        String userName = ...;
        String password = ...;
        connection.login(userName, password);

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                System.out.println("Connected...");
                Mymain mymain = new Mymain(connection);
            }
        });
    } catch (XMPPException exp) {
        exp.printStackTrace();
    }
}