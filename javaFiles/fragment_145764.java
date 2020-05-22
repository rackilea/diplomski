import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(1122);
        System.out.println("Server Ready");
        while(true) {
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            // client must send 1-10 bytes, no more in single command
            byte[] buf = new byte[10]; 
            int read = is.read(buf, 0, buf.length);
            String cmd = new String(buf, 0, read, "UTF-8");
            System.out.println(cmd);
            socket.close(); // we are done, this example reads input and then closes socket
        }
    }

}