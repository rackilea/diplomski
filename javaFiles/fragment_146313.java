public void run() {
    while (runner == Thread.currentThread()) {
        System.out.println("waiting for connection...");
        try {
            try {
                Socket s = server.accept(); //throws SocketException/IOException
                if (session == null) {
                    session = new ReceiveSession(s, parent);
                } else {
                    s.close();
                }
            } catch (SocketException e) {
                if (!e.getMessage().equals("socket closed")) {
                    throw e; //error line, "unreported exception SocketException"
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            parent.showError("Someone tried to connect but the connection failed: " + e);
            session = null;
        }
    }
}