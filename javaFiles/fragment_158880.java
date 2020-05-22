package p1;

import java.io.*;
import java.net.*;

public class Client 
{

public static void main(String[] args) throws Exception
{
    Socket soc=new Socket("127.0.0.1", 9000);
    System.out.println("Client Signing On");

    PrintWriter nos = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(
                    soc.getOutputStream()
            )
            ), true);

    BufferedReader nis = new BufferedReader(
            new InputStreamReader(
                    soc.getInputStream()
            )
    );

    BufferedReader kin = new BufferedReader(
            new InputStreamReader(
                    System.in
            )
    );

    System.out.println("Enter a number");
    String a = kin.readLine(); 

    while(!a.equalsIgnoreCase("end"))
    {
        nos.println(Integer.parseInt(a));  
        String[] s = nis.readLine().split("  ");

        for(String x: s)
            System.out.println(x);


        System.out.println("Enter a number");
        a = kin.readLine();
    }

    nos.println(a);
     System.out.println("Client Signing Off");
     soc.close();
}

}