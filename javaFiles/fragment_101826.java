import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class SendFileExample {
    public static void main(String [] args) throws IOException {
        System.out.print("Type 's' for server or 'c' for client: ");

        char c = (char) System.in.read();
        if(Character.toLowerCase(c) == 's') {
            createServer();
        } else if(Character.toLowerCase(c) == 'c') {
            createClient();
        }
    }

    public static void createServer() throws IOException {
        // create a server to listen on port 12345
        ServerSocket socket = new ServerSocket(12345, 0, InetAddress.getByName("127.0.0.1"));
        System.out.println("Server started on " + socket.getInetAddress().getHostAddress() + ":" + socket.getLocalPort() + ",\nWaiting for client to connect.");
        Socket clientConnection = socket.accept();
        System.out.println("Client accepted from "+clientConnection.getInetAddress().getHostAddress()+", sending file");
        pipeStreams(new FileInputStream(new File("c:\\from.txt")), clientConnection.getOutputStream(), 1024);
        System.out.println("File sent, closing out connection");
        clientConnection.close();
        socket.close();
    }

    public static void createClient() throws IOException {
        System.out.println("Connecting to server.");
        Socket socket = new Socket();
        // connect to an address, this is the server address (which you have to know)
        socket.connect(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 12345));
        // read all bytes from the socket
        System.out.println("Success, retreiving file.");
        pipeStreams(socket.getInputStream(), new FileOutputStream(new File("c:\\to.txt")), 1024);
        System.out.println("Done, file sent. Closing connection");
        socket.close();
    }


    /**
     * writes all bytes from inputStream to outputStream
     * @param source
     * @param out
     * @throws IOException
     */
    public static void pipeStreams(java.io.InputStream source, java.io.OutputStream destination, int bufferSize) throws IOException {

        // 16kb buffer
        byte [] buffer = new byte[bufferSize];
        int read = 0;
        while((read=source.read(buffer)) != -1) {
            destination.write(buffer, 0, read);
        }
        destination.flush();
        destination.close();
        source.close();
    }
}