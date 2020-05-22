private static int bytesToUInt(byte[] input) {
    if (input.length == 3) {
        return (input[2] & 0xFF) << 16 | (input[1] & 0xFF) <<8 | (input[0] & 0xFF);
    }
}
private static int bytesToSInt(byte[] input) {
    if (input.length == 3) {
        return (input[2]) << 16 | (input[1] & 0xFF) <<8 | (input[0] & 0xFF);
    }
}