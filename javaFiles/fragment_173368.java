InetAddress broadcastAddress;

public static InetAddress getBroadcastAddress4() {
    return broadcastAddress;
}

static {
    System.setProperty("java.net.preferIPv4Stack" , "true");

    try {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while(interfaces != null && interfaces.hasMoreElements()){
            NetworkInterface currentInterface = interfaces.nextElement();

            if(!currentInterface.isLoopback()){
                for(InterfaceAddress address : currentInterface.getInterfaceAddresses()){
                    InetAddress broadcast = address.getBroadcast();
                    if(broadcast != null){
                        broadcastAddress = broadcast;
                        break;
                    }
                }
            }
        }
    } catch (SocketException e) {
        // log the damn exception!
        Logger.getLogger(YourClass.class).error("exception when getting broadcast address", e);
    }
}