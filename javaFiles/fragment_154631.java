public static ServerSocket createServerSocket(Class<?> serverClass)
        throws IOException {
    return createServerSocket(serverClass.getName());
}

public static ServerSocket createServerSocket(String fqcn)
        throws IOException {
    Integer port = ports.get(fqcn);
    if (port == null)
        throw new IllegalArgumentException("No server registery found for " + fqcn);
    return new ServerSocket(port);
}

public static Socket createClientSocket(Class<?> serverClass)
        throws UnknownHostException, IOException {
    return createClientSocket(serverClass.getName());
}

public static Socket createClientSocket(String fqcn)
        throws UnknownHostException, IOException {
    Integer port = ports.get(fqcn);
    if (port == null)
        throw new IllegalArgumentException("No server registery found for " + fqcn);
    return new Socket("localhost", port);
}