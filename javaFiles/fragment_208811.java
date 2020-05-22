import java.net.*;


/**
 *
 * @author nick
 */
public class HardwareTruthGen {

   //Instance Variables 
    static InetAddress addr;
    static NetworkInterface net;
    static byte[] macAddr;
    static boolean hardware;

   static {

       try{  
        addr = InetAddress.getLocalHost();
        net = NetworkInterface.getByInetAddress(addr);
        macAddr = net.getHardwareAddress();

        //If mac address ends in an even number return true otherwise return false 
        if((macAddr[(macAddr.length - 1)] % 2) == 0)
            hardware = true;
        else
            hardware = false;
      }
      catch (Exception ex){

      }
    }

   public static boolean macTrue(){ return hardware;}

 }