public static byte[] doplnMezery(byte[] item, int numberOfSpaces) {
    byte[] result = new byte[item.length + numberOfSpaces];
    Arrays.fill(result, 0, numberOfSpaces, (byte) 32);
    System.arraycopy(item, 0, result, numberOfSpaces, item.length);        
    return result;
}