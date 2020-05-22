public static byte[] stringsToBytes(String[] payloadarr) {
    byte[] payload = new byte[payloadarr.length];
    for (int i = 0; i < payloadarr.length; i++) {
        payload[i] = Byte.parseByte(payloadarr[i], 2);
    }
    return payload;
}

public static void main(String[] args) {
    System.out.println(Arrays.toString(stringsToBytes(new String[] { "1011000", "1000010", "1001101", "1000011" })));
}