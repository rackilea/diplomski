import java.net.*;
import java.io.*;
import java.util.*;

public class Client 
{
    public static void main(String[] args) 
    {
        Socket s = null;
        ObjectOutputStream out = null;  
        System.out.println("Connecting to Server ...");
        try 
        {
            s = new Socket("localhost", 1401);
            out = new ObjectOutputStream (s.getOutputStream());
            ArrayList<String> list = ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < 10 ; i++)
    {
        list.add("String"+i);
    }
            out.writeObject(list);out.flush();
        System.out.println("ArrayList sent to Server");
        } catch ( Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            if (out!= null)
            {
                try
                {
                    out.close();
                }
                catch (Exception ex){}
            }
            if (s != null)
            {
                try
                {
                    s.close();
                }
                catch (Exception ex){}
            }
        }
    }
}