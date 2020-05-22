import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main (String args[]) throws Exception {
        DatagramSocket s = new DatagramSocket(9998);
        String msg = "Hello! ,from client. ";
        byte[] b = msg.getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp = new DatagramPacket(b, b.length, ia, 9999);
        s.send(dp);

        byte[] b2 = new byte[1024]; //byte array
        DatagramPacket dip = new DatagramPacket(b2, b2.length);
        s.receive(dip);
        String str = new String(dip.getData(),0,dip.getLength(),"UTF-8");
        System.out.println("From server" + str);
    }
}