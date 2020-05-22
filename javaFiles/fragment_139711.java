package tcpserverclient;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    private static final Logger LOG = Logger.getLogger(Client.class.getName());

    private String getData(InputStream stream2server) {
        BufferedInputStream inputStream = new BufferedInputStream(stream2server);

        StringBuilder incomingData = new StringBuilder("");
        try {
            int c;
            LOG.info("reading incoming data...");
            while ((c = inputStream.read()) != -1) {
                if (c == 0) {
                    break;
                } else {
                    incomingData.append((char) c);
                    System.out.print((char) c);
                }
            }
            LOG.info("\ndata complete.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return incomingData.toString();
    }

    private void startListen(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                LOG.info("\nListening on port " + port);
                Socket socket = serverSocket.accept();
                LOG.info("incoming call...");

                InputStream incoming = socket.getInputStream();
                OutputStream outgoing = socket.getOutputStream();
                String data = getData(incoming);
                LOG.info(data);

                outgoing.close();
                incoming.close();
                socket.close();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client().startListen(9999);
    }
}