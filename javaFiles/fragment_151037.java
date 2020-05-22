public class Example {
    public static long ipToLong(InetAddress ip) {
        byte[] octets = ip.getAddress();
        long result = 0;
        for (byte octet : octets) {
            result <<= 8;
            result |= octet & 0xff;
        }
        return result;
    }

    public static void main(String[] args) throws UnknownHostException {
        long ipLo = ipToLong(InetAddress.getByName("192.200.0.0"));
        long ipHi = ipToLong(InetAddress.getByName("192.255.0.0"));
        long ipToTest = ipToLong(InetAddress.getByName("192.200.3.0"));

        System.out.println(ipToTest >= ipLo && ipToTest <= ipHi);
    }
}