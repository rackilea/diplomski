private static final byte HIGH_NYBLE = (byte) 0xf0;
private static final byte ZONED_NEGATIVE_NYBLE_VALUE = (byte) 0xD0;

    String Sign = "";
    byte signByte = signStr.getBytes(encoding)[0];
    if (((byte) (signByte & HIGH_NYBLE)) == ZONED_NEGATIVE_NYBLE_VALUE) {
        sign = "-";
    }
    byte lastDigitBytes = (byte) (signByte | HIGH_NYBLE);