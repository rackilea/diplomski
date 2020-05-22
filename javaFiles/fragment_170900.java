if(...) {
   try {
      System.out.println(msEndpoint);
      System.out.println(msEndpoint.getTcpPorts());
      String[] split = msEndpoint.getTcpPorts.split(",");
      ...
   }
}