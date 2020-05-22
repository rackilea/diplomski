hostName == null;
Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
{
  while (interfaces.hasMoreElements()) {
    NetworkInterface nic = interfaces.nextElement();
    Enumeration<InetAddress> addresses = nic.getInetAddresses();
    while (hostName == null && addresses.hasMoreElements()) {
      InetAddress address = addresses.nextElement();
      if (!address.isLoopbackAddress()) {
        hostName = address.getHostName();
      }
    }
  }
}