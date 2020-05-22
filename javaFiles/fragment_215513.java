public static void main(String[] args) throws IOException
{
    final InetAddress addr = InetAddress.getByName("10.10.11.8");
    final Socket s = new Socket(addr, 80);

    System.out.println(searchInterface(s.getLocalAddress().getHostAddress()));
}

public static NetworkInterface searchInterface(final String interf)
{
    try
    {
        final Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for(final NetworkInterface netint : Collections.list(nets))
        {
            if(netint.isUp())
            {
                final Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
                for(final InetAddress inetAddress : Collections.list(inetAddresses))
                {
                    if(inetAddress.getHostAddress().equals(interf))
                    {
                        return netint;
                    }
                }
            }
        }
    }
    catch(final SocketException e)
    {
    }

    return null;
}