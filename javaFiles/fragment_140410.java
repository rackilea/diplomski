Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
while (interfaces.hasMoreElements()) {
  NetworkInterface networkInterface = interfaces.nextElement();
  System.out.println(String.format("networkInterface: %s", networkInterface.toString()));

  if (!networkInterface.isUp()) {
    continue;
  }

  for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
    int npf = interfaceAddress.getNetworkPrefixLength();
    InetAddress address = interfaceAddress.getAddress();
    InetAddress broadcast = interfaceAddress.getBroadcast();
    if (broadcast == null && npf != 8) {
      System.out.println(String.format("IPv6: %s; Network Prefix Length: %s", address, npf));
    } else {
      System.out.println(String.format("IPv4: %s; Subnet Mask: %s; Broadcast: %s", address, npf, broadcast));
    }
  }
}