import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import jva.io.BufferedInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.nio.ByteBuffer;

public class SocketClientExample {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
        System.out.println("Attempting connection to GE Reuter Stokes");

        // establish the socket connection to the server
        // using the local IP address, if server is running on some other IP, use that 
        Socket socket = new Socket("10.212.160.4", 3010);
        System.out.println("Socket Connected");

        // write to socket using OutputStream
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Initializing request content
        byte[] request = "<Discovery><CommChannelName>Unknown</CommChannelName></Discovery>".getBytes(StandardCharsets.UTF_8);

        // DataOutputStream.writeInt() writes in big endian and
        // DataInputStream.readInt() reads in big endian.
        // using a ByteBuffer to handle little endian instead.

        byte[] header = new byte[5];
        ByteBuffer buf = ByteBuffer.wrap(header, 1, 4);
        buf.order(ByteOrder.LITTLE_ENDIAN);

        // Initializing request header
        header[0] = (byte) 0xF0;
        buf.putInt(request.length);

        System.out.println("Sending request to Socket Server"); 

        // Sending request
        dos.write(header);
        dos.write(request);
        dos.flush();

        System.out.println("Request was sent. Awaiting response.");

        // read from socket using InputStream
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        // Read response header
        dis.readFully(header);
        buf.flip();

        // Read response content
        byte[] response = new byte[buf.getInt()];
        dis.readFully(response);

        // convert the content into a string
        String message = new String(response, StandardCharsets.UTF_8);
        System.out.println("Message: " + message);

        // close your resources
        dis.close();
        dos.close();
        socket.close();

        Thread.sleep(100);
    }
}