import java.io.IOException;
import java.net.*;
public class Test {
    public void foo() throws IOException{

            ServerSocket server = null; //Initialize server socket here.

            Socket client = server.accept();
            String hostName = client.getInetAddress().getHostName();
        }
}