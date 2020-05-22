public static String[] toStrings(byte[][] bytes) {
    String[] value = new String[bytes.length];

    for(int i=0; i<bytes.length; i++) {
        value[i] = new String(bytes[i]);
    }

    return value;
}