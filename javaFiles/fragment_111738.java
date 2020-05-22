public static void main(String args[]) throws InterruptedException {
    Server server = new Server();
    Client client = new Client();

    Thread tServer = new Thread(server);
    tServer.start();

    //here you can wait some time to Server started

    Thread tClient = new Thread(client);
    tClient.start();
}