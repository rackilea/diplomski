Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
while (interfaces.hasMoreElements()) 
{
    NetworkInterface networkInterface = interfaces.nextElement();
    if (networkInterface.isLoopback())
        continue;    // Do not want to use the loopback interface.
    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) 
    {
        InetAddress broadcast = interfaceAddress.getBroadcast();
        if (broadcast == null)
            continue;

        // Do something with the address.
    }
}