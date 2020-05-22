public long ipToLong(String addr) {
    String[] addrArray = addr.split("\\.");

    return Long.parseLong(addrArray[0]) << 24 +
           Long.parseLong(addrArray[1]) << 16 +
           Long.parseLong(addrArray[2]) << 8 +
           Long.parseLong(addrArray[3]);

}