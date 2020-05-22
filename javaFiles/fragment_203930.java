public class Server {

    private ServerSocket serverSocket;
    private Socket firstConnection;

    public Server {
        try
        {
            serverSocket = new ServerSocket(3333);
            firstConnection = serverSocket.accept();
        }
        catch(IOException e)
        {
            System.out.println("IOError");
        }
    }
}