public class ClientAcceptor implements Runnable {

    @Override
    public void run() {
        while (true) {
            ServerSocket server;
            try {
                server = new ServerSocket(1992);
                Socket client = server.accept();

                if (client.isConnected()) {
                    controller.createClientHandler(client);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}