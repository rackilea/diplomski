import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] inbuffer = new byte[1000];
        DatagramPacket packet = new DatagramPacket(inbuffer, inbuffer.length);
        socket.receive(packet);
        String response = new String(packet.getData(), 0, 
                                     packet.getLength(), "UTF-8");

        System.out.println(response);

        if("<HELLO>".equals(response)){
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }
}

// Client.java
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        byte[] output = "<HELLO>".getBytes("UTF-8");
        DatagramPacket packet = new DatagramPacket(output, output.length, 
                                                   InetAddress.getLocalHost(), 
                                                   9999);
        socket.send(packet);
    }
}