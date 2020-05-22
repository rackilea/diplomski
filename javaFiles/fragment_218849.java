import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer
{
   private final static int PACKETSIZE = 2048 ;

   public static void main( String args[] )
   {
    // Check the arguments
    //      if( args.length != 1 )
    //      {
    //         System.out.println( "usage: DatagramServer port" ) ;
    //         return ;
    //      }

      try
      {
         // Convert the argument to ensure that is it valid
         int port = 1234; //Integer.parseInt( args[0] ) ;
         FileOutputStream output = new FileOutputStream("testStream.ts", true);

         // Construct the socket
         DatagramSocket socket = new DatagramSocket( port ) ;

         System.out.println( "The server is ready..." ) ;

         DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
         for( ;; )
         {
            // Receive a packet (blocking)
            socket.receive( packet );
            try {
                output.write(packet.getData());
            } finally {
                output.close();
            }
        }  
     }catch (IOException exception) {
            exception.printStackTrace();
    }
  }
}