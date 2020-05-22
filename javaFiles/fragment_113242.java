public class ServerM
{   
    public static void main(String args[])
    {

        Listener l = new Listener();
        l.run();

    }

}

class Listener implements Runnable
{
    static InetAddress arr[] = new InetAddress[10];
    static int i = 0;

    public void run()
    {

        try
        {
            ServerSocket ss = new ServerSocket(44444);
            System.out.println("Waiting...");
            while (true) {
                Socket s = ss.accept();
                ClientListener clientListener = new ClientListener(s);
                clientListener.run();
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

class ClientListener implements Runnable {

    private Socket socket;

    public ClientListener(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("Connected!\n");

        DataInputStream din=new DataInputStream(s.getInputStream());
        String ip = din.readUTF();

        InetAddress addr = InetAddress.getByName(ip);

        for(int j=0; j<=i; j++)
        {
            if(arr[j] == addr)
                return;
        }

        arr[i++] = addr;

        ChatThread c = new ChatThread(addr,socket);
        c.run();
    }

}