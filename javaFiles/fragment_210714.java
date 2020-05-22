private static final byte HIGH_NYBLE = (byte) 0xf0;
    private static final byte LOW_NYBLE  = (byte) 0x0f;
    private static final byte ZONED_POSITIVE_NYBLE_OR = (byte) 0xCF;
    private static final byte ZONED_NEGATIVE_NYBLE_OR = (byte) 0xDF;
    private static final byte ZONED_NEGATIVE_NYBLE_VALUE = (byte) 0xD0;                        

    signByte = bytes[bytes.length - 1];

    negative = false;
    if (((byte) (signByte & HIGH_NYBLE)) == ZONED_NEGATIVE_NYBLE_VALUE) {
        negative = true;
    }

    long result = 0;
    for (int i = 0; i < bytes.length; i++) {
        result = result * 10 + (bytes[i] & LOW_NYBLE);
    }

    if (negative) {
       result = -1 * result;
    }