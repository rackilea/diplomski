import java.io.IOException;
import java.net.*;

public class ClientServer {

   private static void runClient() throws IOException {
     InetAddress address = InetAddress.getLocalHost();
     DatagramSocket ds=new DatagramSocket();
     int pos = 0;
     byte[] buffer = new byte[100];
     while (pos < buffer.length) {
       int c = System.in.read();
       buffer[pos++]=(byte)c;
       if ((char)c == '\n') {
         break;
       }
     }
     System.out.println("Sending " + pos + " bytes");
     ds.send(new DatagramPacket(buffer, pos, address, 3000));
  }                   

  private static void runServer() throws IOException {
    byte[] buffer = new byte[100];
    InetAddress address = InetAddress.getLocalHost();
    DatagramSocket ds = new DatagramSocket(3000, address);
    DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
    ds.receive(dp);
    System.out.print(new String(dp.getData(), 0, dp.getLength()));
  }

  public static void main(String args[]) throws IOException {
    if (args.length == 1) {
      runClient();
    } else {
      runServer();
    }
  }
}