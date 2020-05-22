import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    void run() throws Exception {
        DatagramSocket ds = new DatagramSocket(9999);
        byte [] b = new byte[1024];

        DatagramPacket dp = new DatagramPacket(b, b.length);
        ds.receive(dp);
        String msg = new String(dp.getData(),0,dp.getLength(),"UTF-8");
        System.out.println("Message from client:" + msg);

        //giving back to client
        String str = "HI!, from server.";
        byte[] b2 = str.getBytes();
        InetAddress ia = InetAddress.getLocalHost();

        DatagramPacket dop = new DatagramPacket(b2, b2.length, ia, 9998);
        ds.send(dop);
        System.out.println("Message sent back");
        ds.close();
    }

    public static void main(String args[]) throws Exception {
        Server server = new Server();
        server.run();
    }
}