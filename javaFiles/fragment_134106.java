import java.net.NetworkInterface;

...

for (
    final Enumeration< NetworkInterface > interfaces =
        NetworkInterface.getNetworkInterfaces( );
    interfaces.hasMoreElements( );
)
{
    final NetworkInterface cur = interfaces.nextElement( );

    if ( cur.isLoopback( ) )
    {
        continue;
    }

    System.out.println( "interface " + cur.getName( ) );

    for ( final InterfaceAddress addr : cur.getInterfaceAddresses( ) )
    {
        final InetAddress inet_addr = addr.getAddress( );

        if ( !( inet_addr instanceof Inet4Address ) )
        {
            continue;
        }

        System.out.println(
            "  address: " + inet_addr.getHostAddress( ) +
            "/" + addr.getNetworkPrefixLength( )
        );

        System.out.println(
            "  broadcast address: " +
                addr.getBroadcast( ).getHostAddress( )
        );
    }
}