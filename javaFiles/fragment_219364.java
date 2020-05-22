public static String key = "aaaaaaaabbccccbbaaaaaaaabbccccbb"; // 32 characters
private static byte[] key_Array = new byte[32]; // 32 bytes

static {
    // copy the 24 base64-decoded bytes to the key array
    System.arraycopy(Base64.decode(key, Base64.DEFAULT), 0, key_Array, 0, 24);
}