Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

while (networkInterfaces.hasMoreElements()) {
    NetworkInterface networkInterface = networkInterfaces.nextElement();

    System.out.println(networkInterface.getName() + " " +
        networkInterface.getDisplayName());
}