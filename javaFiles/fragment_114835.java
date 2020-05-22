public class ServerThread implements Runnable // or extends Thread
{
    private Socket socket;

    public ServerThread(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        // ...

        socket.close();
    }
}