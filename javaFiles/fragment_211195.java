public class Ipv6AddressCompressor {
    public static String getCompressedAddress(String longAddress) throws UnknownHostException {
        longAddress = Inet6Address.getByName(longAddress).getHostAddress();
        return longAddress.replaceFirst("(^|:)(0+(:|$)){2,8}", "::");
    }
}