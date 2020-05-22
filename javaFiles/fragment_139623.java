public static boolean isThisMyIpAddress(InetAddress addr) {
    // Check if the address is a valid special local or loop back
    if (addr.isAnyLocalAddress() || addr.isLoopbackAddress())
        return true;

    // Check if the address is defined on any interface
    try {
        return NetworkInterface.getByInetAddress(addr) != null;
    } catch (SocketException e) {
        return false;
    }
}