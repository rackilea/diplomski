package p1;

import java.io.*;
import java.net.*;

public class Server
{
 public static void main(String[] args) throws Exception
    {
        System.out.println("Server Signing On");
        ServerSocket ss=new ServerSocket(9000);

        Socket soc=ss.accept();

        BufferedReader nis = new BufferedReader(
                new InputStreamReader(
                        soc.getInputStream()
                )
        );

    PrintWriter nos = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(
                    soc.getOutputStream()
            )
            ), true);

    String ans = "";
    String s = nis.readLine();

    while(!s.equalsIgnoreCase("end"))
    {
    int no = Integer.parseInt(s);

        for (int i = 1; i <= 10; i++) 
            ans += no + " * " + i + " = " + (no * i) + "  ";
            nos.println(ans);
           ans = "";
            s = nis.readLine();
    }
    nos.println(s);

        System.out.println("Server Signing off");
            ss.close();
    }
}