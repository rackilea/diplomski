public class AddressBuilder {
    private String mac1;
    private String mac2;
    private String mac3;
    private String mac4;
    private String mac5;
    private String mac6;
    private String ipv6;
    private static final String IPV6_1 = "FE80::";
    private static final String FF_FE = "FF:FE";
    private static final String DOTS = ":";
    /**
     * Constructor
     */
    public AddressBuilder () { }
    /**
     * setMac
     *
     * @param mac
     * @return
     */
    private static final String LOG_MESSAGE_1 =
            "MAC set to : {%s,%s,%s,%s,%s}";
    public AddressBuilder setMac(String mac){
        String[] splittedMac = mac.split(":");
        this.mac1 = splittedMac[0];
        this.mac2 = splittedMac[1];
        this.mac3 = splittedMac[2];
        this.mac4 = splittedMac[3];
        this.mac5 = splittedMac[4];
        this.mac6 = splittedMac[5];
        log(LOG_MESSAGE_1, splittedMac);
        return this;
    }
    /**
     * throwFffeAndReformatToIPv6Notation
     *
     * @return
     */
    private static final String LOG_MESSAGE_2 =
            "Throwing FFFE and reformat to IPV6 notation : %s";
    public AddressBuilder throwFffeAndReformatToIPv6Notation() {
        StringBuilder sb = new StringBuilder();
        this.ipv6 = sb
            .append(mac1)
            .append(mac2)
            .append(DOTS)
            .append(mac3)
            .append(FF_FE)
            .append(mac4)
            .append(DOTS)
            .append(mac5)
            .append(mac6)
            .toString();
        log(LOG_MESSAGE_2, this.ipv6);
        return this;
    }
    /**
     * convertFirstOctetFromHexToBinaryAndReplaceIt
     *
     * @return
     */
    private static final String LOG_MESSAGE_3 =
            "Convert 1st octet from hex to binary : %s -> %s";
    private static final String LOG_MESSAGE_4 =
            "Invert bit at 6th index : %s";
    private static final String LOG_MESSAGE_5 =
            "Convert this binary string to hex : %s";
    private static final String LOG_MESSAGE_6 =
            "Replace octet with the newly calculated one : %s";
    public AddressBuilder convertFirstOctetFromHexToBinaryAndReplaceIt() {
        String firstOctet = this.ipv6.substring(0, 2);
        String binaryString = new BigInteger(firstOctet, 16).toString(2);
        log(LOG_MESSAGE_3, firstOctet, binaryString);
        char[] binaryCharArray = binaryString.toCharArray();
        binaryCharArray[6] = Integer
            .parseInt(Character.toString(binaryString.toCharArray()[6])) == 0
                ? '1' : '0';
        binaryString = new String(binaryCharArray);
        log(LOG_MESSAGE_4, binaryString);
        String hex1stOctet = new BigInteger(binaryString, 2).toString(16);
        log(LOG_MESSAGE_5, hex1stOctet);
        this.ipv6 = hex1stOctet+this.ipv6.substring(2);
        log(LOG_MESSAGE_6, this.ipv6);
        return this;
    }
    /**
     *
     * prependLocalLinkPrefix
     *
     * @return
     */
    private static final String LOG_MESSAGE_7 =
            "Prepend link local prefix : %s";
    AddressBuilder prependLocalLinkPrefix() {
        this.ipv6 = (IPV6_1+this.ipv6).toUpperCase();
        log(LOG_MESSAGE_7, this.ipv6);
        return this;
    }
    /**
     * build
     *
     * @return
     */
    Address build() {
        return new Address(this.ipv6);
    }
    /**
     * log
     *
     * @param message
     * @param strings
     */
    private static void log(String message, String ...strings) {
        System.out.println(String.format(message, strings));
    }
}