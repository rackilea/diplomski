private static final Map<String, Integer> ports = new HashMap<String, Integer>();

static {
    // These Servers would listen to these ports.
    ports.put("com.stackoverflow.multiconnect.servers.Server1", 5001);
    ports.put("com.stackoverflow.multiconnect.servers.Server2", 5502);
    ports.put("com.stackoverflow.multiconnect.servers.Server3", 8080);
}