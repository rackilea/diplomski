import java.io.*;
import java.net.*;
public class TestCon
{
    public static void main(String[] args)
    {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            echoSocket = new Socket("127.0.0.1", 1337);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            out.println("Hello Server!");
            System.out.println(in.readLine());
            out.close();
            in.close();
            echoSocket.close();
        } catch (UnknownHostException e) {
            System.err.println("Host Unknown");System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection.");System.exit(1);
        }
    }
}