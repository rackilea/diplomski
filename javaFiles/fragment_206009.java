private class ClientThread implements Runnable {
    private Socket socket;

    public ClientThread(Socket socket) {
       this.socket = socket;
    }

    public void run() {
        // read messages from socket and send them to the other client.
    }
}

...

while(true) {
    try {
        client = host.accept();
        Thread t = new Thread(new ClientThread(client));
        t.start();
    } catch (IOException e) {
        System.err.println("Accept failed.");
        System.exit(1);
    }
}