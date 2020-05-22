private static byte[] HexToByte(String hex) {
    if (hex.length() % 2 == 1) {
        throw new IllegalArgumentException("...");
    }

    byte[] arr = new byte[hex.length() / 2];

    for (int i = 0; i < hex.length(); i += 2)
    {
        int highNybble = parseHex(hex.charAt(i));
        int lowNybble = parseHex(hex.charAt(i + 1));
        arr[i / 2] = (byte) ((highNybble << 4) + lowNybble);
    }

    return arr;
}