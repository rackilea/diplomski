String port = getProperty("com.sun.management.jmxremote.port");
if (port == null) {
    port = String.valueOf(getAvailablePort());
    System.setProperty("com.sun.management.jmxremote.port", port);
    System.setProperty("com.sun.management.jmxremote.ssl", "false");
    System.setProperty("com.sun.management.jmxremote.authenticate", "false");

    sun.management.Agent.startAgent();
}
log.info(InetAddress.getLocalHost().getCanonicalHostName() + ":" + port);