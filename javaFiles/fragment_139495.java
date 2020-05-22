URL url = new URL(yourUrlHere);
Proxy proxy = new Proxy(Proxy.Type.DIRECT, 
    new InetSocketAddress( 
        InetAddress.getByAddress(
            new byte[]{your, ip, interface, here}), yourTcpPortHere));
URLConnection conn = url.openConnection(proxy);