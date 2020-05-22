import java.net.*;
import java.util.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NIC {

    public static void main(String args[]) throws Exception {

        List<InetAddress> addrList = new ArrayList<InetAddress>();
        Map<String,String> addressMap = new HashMap<String,String>();

        Enumeration<NetworkInterface> interfaces = null;
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        InetAddress localhost = null;

        try {
            localhost = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        while (interfaces.hasMoreElements()) {
            NetworkInterface ifc = interfaces.nextElement();
            Enumeration<InetAddress> addressesOfAnInterface = ifc.getInetAddresses();

            while (addressesOfAnInterface.hasMoreElements()) {
                InetAddress address = addressesOfAnInterface.nextElement();

                if (!address.equals(localhost) && !address.toString().contains(":")) {
                    addrList.add(address);
                    //System.out.println("\n");
                    System.out.println(address.getHostAddress() + "\r");
                    //System.out.println("\n");

                    try {
                        //InetAddress address = InetAddress.getLocalHost();
                        InetAddress address1 = InetAddress.getByName(address.getHostAddress());

                        /*
                         * Get NetworkInterface for the current host and then read
                         * the hardware address.
                         */
                        NetworkInterface ni = 
                                NetworkInterface.getByInetAddress(address1);
                        if (ni != null) {
                            byte[] mac = ni.getHardwareAddress();
                            if (mac != null) {
                                /*
                                 * Extract each array of mac address and convert it 
                                 * to hexa with the following format 
                                 * 08-00-27-DC-4A-9E.
                                 */

                                String macStr = "";
                                for (int i = 0; i < mac.length; i++) {
                                    macStr += String.format("%02X%s",mac[i], (i < mac.length - 1) ? "-" : "" +"\n");
                                }
                                addressMap.put(address.getHostAddress(), macStr);
                            } else {
                                System.out.println("Address doesn't exist or is not " +
                                        "accessible.");
                            }
                        } else {
                            System.out.println("Network Interface for the specified " +
                                    "address is not found.");
                        }
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (SocketException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        for (Map.Entry<String, String> entry : addressMap.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }
}