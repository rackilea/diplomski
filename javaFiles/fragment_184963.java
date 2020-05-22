public class App {
    public static void main(String[] args) {
        String mac = "CC:BE:59:B3:97:03";
        AddressBuilder ad = new AddressBuilder();
        Address address = ad
            .setMac(mac)
            .throwFffeAndReformatToIPv6Notation()
            .convertFirstOctetFromHexToBinaryAndReplaceIt()
            .prependLocalLinkPrefix()
            .build();
        try {
            System.out.println("is Link local? "+address.isLinkLocal());
            System.out.println("link local : "+address.getIp());
        } catch (UnknownHostException uhe) {
            System.out.println("is Link local? no");
        }
    }
}