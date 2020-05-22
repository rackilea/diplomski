public static String intToIp(int i) {
    return ((i >> 24 ) & 0xFF) + "." +
           ((i >> 16 ) & 0xFF) + "." +
           ((i >>  8 ) & 0xFF) + "." +
           ( i        & 0xFF);
}

public static Long ipToInt(String addr) {
    String[] addrArray = addr.split("\\.");

    long num = 0;
    for (int i=0;i<addrArray.length;i++) {
        int power = 3-i;

        num += ((Integer.parseInt(addrArray[i])%256 * Math.pow(256,power)));
    }
    return num;
}