if (port <= 0)
    port = Registry.REGISTRY_PORT;

if (host == null || host.length() == 0) {
    // If host is blank (as returned by "file:" URL in 1.0.2 used in
    // java.rmi.Naming), try to convert to real local host name so
    // that the RegistryImpl's checkAccess will not fail.
    try {
       host = java.net.InetAddress.getLocalHost().getHostAddress();
    } catch (Exception e) {
       // If that failed, at least try "" (localhost) anyway...
       host = "";
    }