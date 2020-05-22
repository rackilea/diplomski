String hostName = InetAddress.getLocalHost().getHostName();

InetAddress addrs[] = InetAddress.getAllByName(hostName);

String myIp = "UNKNOWN";
for (InetAddress addr: addrs) {
  System.out.println ("addr.getHostAddress() = " + addr.getHostAddress());
  System.out.println ("addr.getHostName() = " + addr.getHostName());
  System.out.println ("addr.isAnyLocalAddress() = " + addr.isAnyLocalAddress());
  System.out.println ("addr.isLinkLocalAddress() = " + addr.isLinkLocalAddress());
  System.out.println ("addr.isLoopbackAddress() = " + addr.isLoopbackAddress());
  System.out.println ("addr.isMulticastAddress() = " + addr.isMulticastAddress());
  System.out.println ("addr.isSiteLocalAddress() = " + addr.isSiteLocalAddress());
  System.out.println ("");

  if (!addr.isLoopbackAddress() && addr.isSiteLocalAddress()) {
    myIp = addr.getHostAddress();
  }
}