public static int crc16_update(int crc, byte a) {
    crc ^= ((a+128) & 0xff);
    for (int i = 0; i < 8; ++i) {
        if ((crc & 1) != 0) {
            crc = ((crc >>> 1) ^ 0xA001) & 0xffff;
        }
        else {
            crc = (crc >>> 1) & 0xffff;
        }
    }
    return crc;
}

public static short crc16(byte[] bytes) {
    int crc = 0;
    for (byte b : bytes) {
        crc = crc16_update(crc, b);
    }
    return (short) crc;
}