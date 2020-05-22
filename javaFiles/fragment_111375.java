public String getMyFacesIp() {
    String ip = "";
    try {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while(interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            if(iface.isLoopback() || !iface.isUp()) {
                continue;
            }

            Enumeration<InetAddress> addresses = iface.getInetAddresses();
            while(addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                ip = addr.getHostAddress();
                if(ip.startsWith("192")) {
                    return ip;
                }
            }
        }
    } catch (Exception e) {}
    return ip;

}