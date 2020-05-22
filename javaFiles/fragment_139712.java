package tcpserverclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Server {

    public void sendCommand(String ip, int port, String cmd) {
        try {
            Socket socket = new Socket(ip, port);
            InputStream fromServer = socket.getInputStream();
            OutputStream toServer = socket.getOutputStream();
            socket.setSoTimeout(0);

            byte[] ba = cmd.getBytes();
            byte[] ba0 = new byte[ba.length + 1];
            System.arraycopy(ba, 0, ba0, 0, ba.length);
            ba0[ba.length] = 0;

            toServer.write(ba0);

            fromServer.close();
            toServer.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().sendCommand("127.0.0.1", 9999, "Hal, can you read me?");
    }
}