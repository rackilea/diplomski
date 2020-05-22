public void addHostToCacheAs(String hostname, String ipAddress) throws UnknownHostException, TextParseException {
    //add an ending period assuming the hostname is truly an absolute hostname
    Name host = new Name(hostname + ".");
    //putting in a good long TTL, and using an A record, but AAAA might be desired as well for IPv6
    Record aRec = new ARecord(host, Type.A, 9999999, getInetAddressFromString(ipAddress));
    Lookup.getDefaultCache(Type.A).addRecord(aRec, Credibility.NORMAL,this);
}


public InetAddress getInetAddressFromString(String ip) throws UnknownHostException {
    //Assume we are using IPv4
    byte[] bytes = new byte[4];
    String[] ipParts = ip.split("\\.");
    InetAddress addr = null;
    //if we only have one part, it must actually be a hostname, rather than a real IP
    if (ipParts.length <= 1) {
        addr = InetAddress.getByName(ip);
    } else {
        for (int i = 0; i < ipParts.length; i++) {
            bytes[i] = Byte.parseByte(ipParts[i]);
        }
        addr = InetAddress.getByAddress(bytes);
    }
    return addr
}