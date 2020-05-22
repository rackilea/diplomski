class ModbusConvert
{
    public static long toUnsigned(int register0, int register1, int register2)
    {
        //NOTE: Assumes long is 64-bit, int is 32-bit

        // Convert each register to a long in the appropriate bit position and OR them together
        long v2 = (((long)register2) & 0x0FFFF);
        long v1 = (((long)register1) & 0x0FFFF) << 16;
        long v0 = (((long)register0) & 0x0FFFF) << 32;
        return v0 | v1 | v2;
    }

    public static long toSigned(int register0, int register1, int register2)
    {
        //NOTE: Assumes long is 64-bit, int is 32-bit

        // Convert each register to a long in the appropriate bit position and OR them together
        if ((register0 & 0x8000) != 0) register0 |= 0xFFFF0000; // Sign extend

        long v2 = (((long)register2) & 0x0FFFF);
        long v1 = (((long)register1) & 0x0FFFF) << 16;
        long v0 = ((long)register0) << 32;
        return v0 | v1 | v2;
    }

    public static void main(String args[])
    {
        // Example Register Values (value = 0xFEDC76543210)
        int register0 = 0xFEDC;
        int register1 = 0x7654;
        int register2 = 0x3210;

        long unsigned = toUnsigned(register0, register1, register2);
        long signed = toSigned(register0, register1, register2);

        System.out.println(String.format("UNSIGNED: 0x%016X", unsigned));
        System.out.println(String.format("SIGNED  : 0x%016X", signed));
    }
}

The output is:
UNSIGNED: 0x0000FEDC76543210
SIGNED  : 0xFFFFFEDC76543210