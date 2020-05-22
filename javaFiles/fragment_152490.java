try {
  InetAddress localhost = InetAddress.getLocalHost();
  LOG.info(" IP Addr: " + localhost.getHostAddress());
  // Just in case this host has multiple IP addresses....
  InetAddress[] allMyIps = InetAddress.getAllByName(localhost.getCanonicalHostName());
  if (allMyIps != null && allMyIps.length > 1) {
    LOG.info(" Full list of IP addresses:");
    for (int i = 0; i < allMyIps.length; i++) {
      LOG.info("    " + allMyIps[i]);
    }
  }
} catch (UnknownHostException e) {
  LOG.info(" (error retrieving server host name)");
}

try {
  LOG.info("Full list of Network Interfaces:");
  for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
    NetworkInterface intf = en.nextElement();
    LOG.info("    " + intf.getName() + " " + intf.getDisplayName());
    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
      LOG.info("        " + enumIpAddr.nextElement().toString());
    }
  }
} catch (SocketException e) {
  LOG.info(" (error retrieving network interface list)");
}