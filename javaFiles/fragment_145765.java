import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = null;
        // send max of 10 bytes to simplify this example
        String str = "ABCDEFGHIJ"; 
        try {
            socket = new Socket("localhost", 1122);
            OutputStream os = socket.getOutputStream();
            byte[] buf = str.getBytes("UTF-8");
            os.write(buf, 0, buf.length);
            os.flush();
        } catch (IOException ex) {
            System.err.print(ex);
        } finally {
            socket.close();
        }
    }

}