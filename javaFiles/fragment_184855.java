Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();

for (NetworkInterface netIf : Collections.list(nets))
{
    System.out.println("Display name: " + netIf.getDisplayName());
    System.out.println("Name: " + netIf.getName());

    if (netIf.isUp()) //Is the interface up
    {
        Enumeration<InetAddress> inetAddresses = netIf.getInetAddresses();

        for (InetAddress inetAddress : Collections.list(inetAddresses))
        {
            System.out.println("InetAddress: " + inetAddress);
        }
    }
}