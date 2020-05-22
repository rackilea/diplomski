InetAddress a = InetAddress.getByName(“www.sun.com”);
if (a instanceof Inet6Address) {
    Inet6Address a2 = (Inet6Address) a;
    if (a2.isIPv4CompatibleAddress()) {
        ...
    } if (
        a2.isLinkLocalAddress()) {
        ...
    }
}