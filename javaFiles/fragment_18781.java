public static byte[][] toBinary(String... strs) {
    byte[][] value = new byte[strs.length][];

    for(int i=0; i<strs.length; i++) {
        value[i] = strs[i].getBytes();
    }

    return value;
}