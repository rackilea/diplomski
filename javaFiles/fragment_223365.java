public class SubnetMask {

    private int prefix;

    public SubnetMask(int prefix) {
        if (prefix < 8 || prefix > 30) {
            throw new IllegalArgumentException("Prefix must be in [8;32]");
        }
        this.prefix = prefix;
    }

    public long getNrOfAvailableAddresses() {
        return (long) Math.pow(2, 32 - this.prefix) - 2;
    }

    // returns something like "255.255.192.0"
    public String getSubnetMaskRepresentation() {
        long bits = 0xffffffff ^ (1 << 32 - this.prefix) - 1;
        return String.format("%d.%d.%d.%d", 
                 (bits & 0x0000000000ff000000L) >> 24, 
                 (bits & 0x0000000000ff0000) >> 16, 
                 (bits & 0x0000000000ff00) >> 8, bits & 0xff);
    }
}