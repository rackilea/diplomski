public void startServer(int port) {

try {
    ServerSocket welcomeSocket = new ServerSocket(port);

    while (true) {
        // Create the Client Socket
        Socket clientSocket = welcomeSocket.accept();
        ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());

        Message m = (Message) inFromClient.readObject();

        System.out.println("---- hello: my message is: " + m.name);
    }
} catch (Exception e) {
    System.err.println("Server Error: " + e.getMessage());
    System.err.println("Localized: " + e.getLocalizedMessage());
    System.err.println("Stack Trace: " + e.getStackTrace());
    System.err.println("To String: " + e.toString());
}

}