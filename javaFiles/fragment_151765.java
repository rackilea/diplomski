import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws Exception {

        int port = 7999;
        ServerSocket s = new ServerSocket(port);
        Socket client = s.accept();
        ObjectInputStream is = new ObjectInputStream(client.getInputStream());

        String str = (String)is.readObject();

        System.out.println("Read string: " + str);

        is.close();
    }

}