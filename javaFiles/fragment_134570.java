public static void main(String args[]) throws IOException {
    String s;
    initGUI();
    hostServer = new ServerSocket(port);
    while (true) {
        try {
            // wait for the next client to connect
            socket = hostServer.accept();
        } catch (IOException e) {
            cleanUp();
            changeStatusTS(DISCONNECTED, false);
            break;
        }
        area.append(" " + socket + " connection\n");
        // you probably don't want this or you want this to be per client?
        changeStatusTS(CONNECTED, true);
        // start a multi thread on the accepted socket
        Multi ml = new Multi(socket);
        ml.start();
    }
}