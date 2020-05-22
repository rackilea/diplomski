import java.net.InetAddress;
 import java.util.Date;
 import org.apache.commons.net.ntp.NTPUDPClient; 
 import org.apache.commons.net.ntp.TimeInfo;

     public class TimeLookup {

    public static void main() throws Exception {
                String TIME_SERVER = "time-a.nist.gov";   
        NTPUDPClient timeClient = new NTPUDPClient();
        InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
        TimeInfo timeInfo = timeClient.getTime(inetAddress);
        long returnTime = timeInfo.getReturnTime();
        Date time = new Date(returnTime);
        System.out.println("Time from " + TIME_SERVER + ": " + time);
    }
}