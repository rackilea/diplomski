import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    Server()
    {
        Socket s = null;
        byte[] bytearray = new byte[4096];
        try (ServerSocket ss = new ServerSocket(4444))
        {
            s = ss.accept();
            InputStream is = s.getInputStream();

            // 1. Recieve data and put it to UpperCase.
            String data = "";
            int count;
            while((count = is.read(bytearray)) > 0)
            {
                data += new String(bytearray, 0, count);
            }
            data = data.toUpperCase();
            System.out.println(data);

            // 2. Send back data.
            OutputStream os = s.getOutputStream();
            os.write(data.getBytes());
            os.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}