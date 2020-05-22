Enumeration Interfaces = NetworkInterface.getNetworkInterfaces();
while(Interfaces.hasMoreElements())
{
    NetworkInterface Interface = (NetworkInterface)Interfaces.nextElement();
    Enumeration Addresses = Interface.getInetAddresses();
    while(Addresses.hasMoreElements())
    {
        InetAddress Address = (InetAddress)Addresses.nextElement();
        System.out.println(Address.getHostAddress());
    }
 }