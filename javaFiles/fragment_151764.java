import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int port = 7999;
        Socket s = new Socket(host, port);
        ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());

        os.writeObject("Hello World");
        os.close();
    }

}