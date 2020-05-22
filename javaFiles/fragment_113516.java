import java.util.*;
import java.net.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Enumeration<NetworkInterface> interfaces =
            NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements())
        {
            NetworkInterface iface = interfaces.nextElement();
            System.out.println(iface.getDisplayName());
            for (InterfaceAddress address :
                 iface.getInterfaceAddresses())
            {
                System.out.println("  " + address);
            }
        }
    }
}