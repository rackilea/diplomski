/*
 * Class for calculating CRC16CITT. 
 */
public class CRC16CCITT {

    private static int crc = 0;

    public static void calc_crc(int character) {
        int crc_tmp;
        crc_tmp = ((crc ^ character) & 0x0F);
        crc = (crc >>> 4) ^ (crc_tmp * 4225);
        crc_tmp = ((crc ^ (character >>> 4)) & 0x0F);
        crc = (crc >>> 4) ^ (crc_tmp * 4225);
    }

    public static void update(byte b) {
        calc_crc(b);
    }

    public static void reset() {
        crc = 0;
    }

    public static int highByte() {
        return (( crc >> 8) & 0xFF);

    }

    public static int lowByte() {
        return crc & 0xFF;
    }

     public static int value() {
        return crc;
    }
}