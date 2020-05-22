public String getHostName() {
    String hostName = "";
    try {
        java.net.InetAddress addr = InetAddress.getLocalHost();
        hostName = addr.getHostName();
    } catch (UnknownHostException ex) {
      System.out.println("Hostname can not be resolved");
    }
    return hostName; }