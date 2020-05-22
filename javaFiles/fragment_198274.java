import java.net.*;
import java.io.*;
import java.util.*;

public class Server 
{
    public static void main(String[] args) 
    {
        ObjectInputStream oin = null;
        ServerSocket server;
        Socket socket = null;
        try
        {
            server = new ServerSocket(1401);
            socket = server.accept();
            System.out.println("Client Connected..Sending ArrayList to Client");
            oin = new ObjectInputStream(socket.getInputStream());
            ArrayList<String> list = (ArrayList<String>)oin.readObject();
        System.out.println("Recieved ArrayList from client "+list);
            //Writing to file now 
            FileOutputStream fos = new FileOutputStream("Filename.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.write(obj);
            fos.close();
            out.close();
            System.out.println("Written to file");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (oin != null)
            {
                try
                {
                    oin.close();
                }
                catch (Exception ex){}
            }
            if (socket != null)
            {
                try
                {
                    socket.close();
                }
                catch (Exception ex){}
            }
        }
    }
}