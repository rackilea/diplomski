import java.io.File;

public class Test
{
    public static void main(String[] args)
    {
        Client c = new Client();
        (new Thread()
        {
            public void run()
            {
                Server s = new Server();
            }
        }).start();
        c.send(new File("test.txt"));
    }
}